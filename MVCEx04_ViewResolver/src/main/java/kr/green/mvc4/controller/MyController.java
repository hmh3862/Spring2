package kr.green.mvc4.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.green.mvc4.service.RssService;
import kr.green.mvc4.vo.PersonVO;
import kr.green.mvc4.vo.Pizza;
import kr.green.mvc4.vo.Rss;

@RestController
public class MyController {
	
	@Autowired
	private RssService rssService;

	@GetMapping(value = "/rest/Pizza", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Pizza getPizza() {
		return new Pizza("고구마");
	}
	@GetMapping(value = "/rest/Pizza.json", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Pizza getPizza2() {
		return new Pizza("고구마");
	}
	@GetMapping(value = "/rest/Pizza.xml", produces = {MediaType.APPLICATION_XML_VALUE})
	public Pizza getPizza3() {
		return new Pizza("고구마");
	}
	@RequestMapping(value = "/rest/hello", produces = "text/plain;charset=UTF-8")
	public String getHello() {
		return "안녕하세요!!!";
	}
	
	@RequestMapping(value = "/rest/personVO.xml", produces = {MediaType.APPLICATION_XML_VALUE})
	public PersonVO getPersonVOXML() {
		return new PersonVO("한사람", new Date(122,3,9), true);
	}
	
	@RequestMapping(value = "/rest/personVO.json", produces = {MediaType.APPLICATION_JSON_VALUE})
	public PersonVO getPersonVOJSON() {
		return new PersonVO("한사람", new Date(122,3,9), true);
	}
	
	@RequestMapping(value = "/rest/rss1.json", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Rss getRssJSON() {
		return rssService.readRss("https://rss.etnews.com/Section902.xml");
	}

	@RequestMapping(value = "/rest/rss2.json", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Rss getRssJSON2() {
		return rssService.readRss("https://rss.etnews.com/Section902.xml");
	}
}
