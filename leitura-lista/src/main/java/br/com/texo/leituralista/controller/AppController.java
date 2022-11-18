package br.com.texo.leituralista.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.com.texo.leituralista.config.GreetingConfig;
import br.com.texo.leituralista.config.Util;
import br.com.texo.leituralista.dto.AwardsIntervalDTO;
import br.com.texo.leituralista.dto.MovieDTO;
import br.com.texo.leituralista.dto.MovieWinDTO;
import br.com.texo.leituralista.dto.StudioDTO;
import br.com.texo.leituralista.entity.AwardsIntervalEntity;
import br.com.texo.leituralista.entity.MovieEntity;
import br.com.texo.leituralista.messages.BadRequestMessage;
import br.com.texo.leituralista.messages.ForbiddenMessage;
import br.com.texo.leituralista.messages.MethodNotAllowedMessage;
import br.com.texo.leituralista.models.AwardsIntervalModel;
import br.com.texo.leituralista.models.ReturnStatusModel;
import br.com.texo.leituralista.models.StudiosModel;
import br.com.texo.leituralista.repository.AwardsIntervalRepository;
import br.com.texo.leituralista.repository.MovieRepository;
import br.com.texo.leituralista.repository.StudioRepository;

@ControllerAdvice
@RestController
@RequestMapping(value = { "/" })
public class AppController {

	RequestMappingHandlerMapping requestMappingHandlerMapping;
	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private StudioRepository studioRepository;

	@Autowired
	private AwardsIntervalRepository awardsIntervalRepository;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping(value = "/greetings/{name}", method = RequestMethod.GET)
	public GreetingConfig greetingMsg(@PathVariable String name) {
		return new GreetingConfig(counter.incrementAndGet(),
				String.format(template, name));
	}

	@RequestMapping(value = "/greetings", method = RequestMethod.GET)
	public GreetingConfig greeting() {
		return new GreetingConfig(counter.incrementAndGet(),
				String.format(template, "World"));
	}

	@RequestMapping(value = "/movies/{year}", method = RequestMethod.GET)
	public MovieDTO listForYear(HttpServletRequest request, @PathVariable("year") String year)
			throws BadRequestMessage {

		try {
			@SuppressWarnings("unused")
			int yearPar = Integer.parseInt(year);
		} catch (Exception e) {
			throw new BadRequestMessage("");
		}

		if (year.length() != 4) {
			throw new BadRequestMessage("");
		}

		System.out.println("Ano: " + year);

		List<MovieEntity> data = movieRepository.findMoviesByYear(year);
		MovieDTO moviesData = new MovieDTO();
		moviesData.setMovies(data);
		return moviesData;
	}

	@RequestMapping(value = "/movies/yearsmoreonewinners")
	public MovieWinDTO listWinnersMoreOneYear(HttpServletRequest request)
			throws MethodNotAllowedException {

		String strMethod = "GET";
		System.out.println("Method: " + request.getMethod());
		if (!request.getMethod().equals(strMethod)) {
			throw new MethodNotAllowedMessage("");
		}

		Iterable<AwardsIntervalModel> ite = movieRepository.moviesWinnersMoreOneYear();
		List<AwardsIntervalModel> listagem = Util.toList(ite);

		@SuppressWarnings({ "rawtypes" })
		Iterator itr = listagem.iterator();

		List<AwardsIntervalModel> dataWinn = new ArrayList<AwardsIntervalModel>();
		MovieWinDTO dataYears = new MovieWinDTO();

		while (itr.hasNext()) {
			Object[] arrObj = (Object[]) itr.next();
			dataWinn
					.add(new AwardsIntervalModel(String.valueOf(arrObj[0]), Integer.parseInt(String.valueOf(arrObj[1]))));
		}

		dataYears.setYears(dataWinn);
		return dataYears;
	}

	@RequestMapping(value = "/movies/studiosorderwinns")
	public StudioDTO listForStudios(HttpServletRequest request)
			throws MethodNotAllowedException {

		String strMethod = "GET";
		System.out.println("Method: " + request.getMethod());
		if (!request.getMethod().equals(strMethod)) {
			throw new MethodNotAllowedMessage("");
		}

		Iterable<StudiosModel> ite = studioRepository.studiosOrderWinns();
		List<StudiosModel> listagem = Util.toList(ite);

		@SuppressWarnings("rawtypes")
		Iterator itr = listagem.iterator();

		List<StudiosModel> orderWinn = new ArrayList<StudiosModel>();
		StudioDTO dataStudios = new StudioDTO();

		while (itr.hasNext()) {
			Object[] arrObj = (Object[]) itr.next();
			orderWinn.add(new StudiosModel(String.valueOf(arrObj[0]), Integer.parseInt(String.valueOf(arrObj[1]))));
		}

		dataStudios.setStudios(orderWinn);
		return dataStudios;
	}

	@RequestMapping(value = "/movies/awardsinterval")
	public AwardsIntervalDTO listForAwardsInterval(HttpServletRequest request)
			throws MethodNotAllowedException {

		String strMethod = "GET";
		System.out.println("Method: " + request.getMethod());
		if (!request.getMethod().equals(strMethod)) {
			throw new MethodNotAllowedMessage("");
		}

		Iterable<AwardsIntervalEntity> ite = awardsIntervalRepository.awardsInterval();
		List<AwardsIntervalEntity> listagem = Util.toList(ite);

		@SuppressWarnings({ "rawtypes" })
		Iterator itr = listagem.iterator();

		List<AwardsIntervalEntity> intervalMin = new ArrayList<AwardsIntervalEntity>();
		List<AwardsIntervalEntity> intervalMax = new ArrayList<AwardsIntervalEntity>();
		AwardsIntervalDTO awardsIntervalDTO = new AwardsIntervalDTO();

		String producer;
		int interval;
		int previousWin;
		int followingWin;
		int i = 0;

		while (itr.hasNext()) {
			i++;
			Object[] arrObj = (Object[])

			itr.next();
			producer = String.valueOf(arrObj[0]);
			interval = Integer.parseInt(String.valueOf(arrObj[1]));
			previousWin = Integer.parseInt(String.valueOf(arrObj[2]));
			followingWin = Integer.parseInt(String.valueOf(arrObj[3]));

			if (i == 1) { // MAX INTERVAL
				intervalMax.add(new AwardsIntervalEntity(producer, interval, previousWin, followingWin));
			} else { // MIN INTERVAL
				intervalMin.add(new AwardsIntervalEntity(producer, interval, previousWin, followingWin));
			}
		}

		awardsIntervalDTO.setMin(intervalMin);
		awardsIntervalDTO.setMax(intervalMax);
		return awardsIntervalDTO;
	}

	@RequestMapping(value = "/movies/{id}", produces = "application/json")
	public ResponseEntity<ReturnStatusModel> deleteMovie(HttpServletRequest request, @PathVariable("id") String id,
			final HttpServletResponse response)
			throws ForbiddenMessage, NotFoundException, MethodNotAllowedMessage, JsonProcessingException,
			BadRequestMessage {

		String strMethod = "DELETE";
		System.out.println("Method: " + request.getMethod());
		if (!request.getMethod().equals(strMethod)) {
			throw new MethodNotAllowedMessage("");
		}

		Long idPar;

		try {
			idPar = Long.parseLong(id);
		} catch (Exception e) {
			throw new BadRequestMessage("");
		}

		ReturnStatusModel returnStatus = new ReturnStatusModel("00201", request.getRequestURL().toString());
		MovieEntity movie = movieRepository.findOne(idPar);

		if (movie == null) {
			throw new NotFoundException();
		} else {
			System.out.println("Vencedor: " + movie.getWinner());
			if (movie.getWinner()) {
				throw new ForbiddenMessage("");
			} else {
				movieRepository.delete(movie);
			}
		}
		return new ResponseEntity<>(returnStatus, HttpStatus.OK);
	}

}
