package kr.green.mvc4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.green.mvc4.service.RssService;
import kr.green.mvc4.vo.Pizza;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private RssService rssService;
	
	
	@RequestMapping(value = "/rss1")
	public String readRss(Model model) {
		model.addAttribute("rss", rssService.readRss("https://rss.etnews.com/Section902.xml"));
		return "rss";
	}
	
	@RequestMapping(value = "/rss2")
	public String readRss2(Model model) {
		model.addAttribute("rss", rssService.readRss("https://rss.hankyung.com/feed/politics.xml"));
		return "rss";
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}

	@RequestMapping(value = "/pizza") // JSP파일을 통과해서 출력을 해라
	public String getPizza(Model model) {
		model.addAttribute("pizza", new Pizza("불고기"));
		return "pizza";
	}
	@RequestMapping(value = "/Pizza")
	@ResponseBody // JSP를 통과하지 않고 바로 출력해라
	public Pizza getPizza() {
		return new Pizza("고구마");
	}
	@RequestMapping(value = "/Pizza.xml", produces = {MediaType.APPLICATION_XML_VALUE})
	@ResponseBody // JSP를 통과하지 않고 바로 출력해라
	public Pizza getPizza2() {
		return new Pizza("고구마");
	}
	@RequestMapping(value = "/Pizza.json", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody // JSP를 통과하지 않고 바로 출력해라
	public Pizza getPizza3() {
		return new Pizza("고구마");
	}
}
