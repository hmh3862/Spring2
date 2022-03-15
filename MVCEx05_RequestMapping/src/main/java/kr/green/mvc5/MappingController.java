package kr.green.mvc5;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kr.green.mvc5.vo.CommVO;
import kr.green.mvc5.vo.MemoVO;
import kr.green.mvc5.vo.TestVO1;
import kr.green.mvc5.vo.TestVO2;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MappingController {
	
	// jsp파일이름을 리턴하게 만들어 준다.
	// @RequestMapping은 주소를 한 생성한다.
	@RequestMapping(value = "/method01", method = RequestMethod.GET) // value의 값이 주소, nethod가 요청 방식(생략시 모두 됨)
	// @GetMapping : GET방식
	// @PostMapping : POST방식
	public String metnod01() {
		// 여기에서는 서비스 클래스를 호출하여 처리를 한다.
		log.info("/method01 {}", "호출");
		return "method01";// jsp 파일이름을 리턴한다.
	}
	@RequestMapping(value = {"/m02","/m02.it", "/admin/m02"}) // 하나를 여러개의 주소로 호출가능하게 한다.
	public String metnod02() {
		// 여기에서는 서비스 클래스를 호출하여 처리를 한다.
		log.info("/method02 {}", "호출");
		return "method02";// jsp 파일이름을 리턴한다.
	}
	
	@RequestMapping(value = "/m03")
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method03() {
		log.info("/method03 {}", "호출");
		return "한글qwerty1234!@#$"; // 한글이 깨진다.
	}
	
	@RequestMapping(value = "/m04", produces = "text/plain;charset=UTF-8") // content타입 지정. charset반드시 소문자!!!
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method04() {
		log.info("/method04 {}", "호출");
		return "한글qwerty1234!@#$"; // 한글이 깨지지 않는다.
	}
	
	// GET/POST 다르게 지정
	@RequestMapping(value = "/m05", produces = "text/plain;charset=UTF-8", method = RequestMethod.GET) // GET방식 요청시만
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method05() {
		log.info("/method05 {}", "호출");
		return "한글qwerty1234!@#$ GET GET GET"; 
	}
	
	// 그냥 폼
	@RequestMapping(value = "/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(value = "/m05", produces = "text/plain;charset=UTF-8", method = RequestMethod.POST) // POST방식 요청시만
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method06() {
		log.info("/method06 {}", "호출");
		return "한글qwerty1234!@#$ POST POST POST"; 
	}
	
	@RequestMapping(value = "/xml1", produces = "text/plain;charset=UTF-8") // XML을 text방식으로 출력 : 형식을 텍스트로 인식
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method07() {
		log.info("/method07 {}", "호출");
		return "<com><cpu>686</cpu><ram>32GB</ram></com>"; 
	}
	
	@RequestMapping(value = "/xml2", produces = "application/xml;charset=UTF-8") // XML을 xml방식으로 출력 : 형식을 XML로 인식
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method08() {
		log.info("/method06 {}", "호출");
		return "<com><cpu>686</cpu><ram>32GB</ram></com>"; 
	}
	@RequestMapping(value = "/xml3", produces = {MediaType.APPLICATION_XML_VALUE}) // XML을 xml방식으로 출력 : 형식을 XML로 인식
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method08_1() {
		log.info("/method08_1 {}", "호출");
		return "<com><cpu>686</cpu><ram>32GB</ram></com>"; 
	}

	@RequestMapping(value = "/json1", produces = "text/plain;charset=UTF-8") // JSON을 text방식으로 출력 : 형식을 텍스트로 인식
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method09() {
		log.info("/method09 {}", "호출");
		return "{\"name\":\"한사람\",\"age\":33}"; 
	}
	
	@RequestMapping(value = "/json2", produces = "application/json;charset=UTF-8") // JSON을 JSON방식으로 출력 : 형식을 JSON로 인식
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method10() {
		log.info("/method10 {}", "호출");
		return "{\"name\":\"한사람\",\"age\":33}"; 
	}
	
	@RequestMapping(value = "/json3", produces = {MediaType.APPLICATION_JSON_VALUE}) // JSON을 JSON방식으로 출력 : 형식을 JSON로 인식
	@ResponseBody // JSP파일을 통과하지 않고 그냥 출력해라!!!
	public String method11() {
		log.info("/method11 {}", "호출");
		return "{\"name\":\"한사람\",\"age\":33}"; 
	}
	@RequestMapping(value = "/testVO1", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public TestVO1 testVO1() {
		return new TestVO1("한사람",22,true); // json 출력 : 
	}
	
	@RequestMapping(value = "/testVO21", produces = {MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public TestVO2 testVO21() {
		return new TestVO2("한사람",22,true); // json출력
	}
	
	@RequestMapping(value = "/testVO22")
	@ResponseBody
	public TestVO2 testVO22() {
		return new TestVO2("한사람",22,true); // xml 출력 : VO에 @XmlRootElement 추가시
	}
	
	//-------------------------------------------------------------------------------------
	// Path를 이용하여 데이터를 받아보자
	@RequestMapping(value = "/name/{id}", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String path01(@PathVariable int id) {
		return "<h1>Path를 이용하여 데이터를 받아보자. 받은값 : " + id + "</h1>";
	}
	
	@RequestMapping(value = "/{name}/{no}", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String path02(@PathVariable String name, @PathVariable(required = false, name = "no") Integer age) {
		return "<h1>" + name  + "님 " + age +  "살이네 행님이라 불러</h1>";
	}
	
	//------------------------------------------------------------------------------------------------------------
	// GET방식의 요청 받기
	@RequestMapping(value = "/get1", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String get1(HttpServletRequest request) { // 값이 넘어오지 않으면 에러
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		return "<h1>" + name  + "님 " + age +  "살이네 행님이라 불러</h1>";
	}
	
	@RequestMapping(value = "/get2", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String get2(@RequestParam String name, @RequestParam Integer age ) { // 값이 넘어오지 않으면 에러
		return "<h1>" + name  + "님 " + age +  "살이네 행님이라 불러</h1>";
	}
	
	@RequestMapping(value = "/get3", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String get3(@RequestParam(defaultValue = "무명", required = false) String name, // required = false로 필수여부 지정
			           @RequestParam(defaultValue = "11", required = false) int age ) {
		               // defaultValue로 기본 값 지정하면 넘어오지 않아도 에러가 발생하지 않는다.
		return "<h1>" + name  + "님 내년에" + (age+1) +  "살이네 행님이라 불러</h1>";
	}
	
	@RequestMapping(value = "/session")
	public String session(@RequestParam(defaultValue = "무명", required = false) String name, 
			@RequestParam(defaultValue = "11", required = false) int age, HttpSession session, HttpServletRequest request) {
		// 세션이나  Request 필요하면 인수로 받으면 된다.
		session.setAttribute("name", name + " : Session");
		session.setAttribute("age", age + " : Session");

		request.setAttribute("name", name + " : Request");
		request.setAttribute("age", age + " : Request");
		return "session";
	}
	
	@RequestMapping(value = "/model")
	public String model(@RequestParam(defaultValue = "무명", required = false) String name, 
			@RequestParam(defaultValue = "11", required = false) int age, Model model) {
		// 스프링에서는 Model에 추가해주면 뷰페이지에서 사용 가능하다.
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "model";
	}
	
	// 예전 코드들은 리턴을 ModelAndView를 사용한 코드가 많다.
	@RequestMapping(value = "/mv")
	public ModelAndView modelAndView(@RequestParam(defaultValue = "무명", required = false) String name, 
			@RequestParam(defaultValue = "11", required = false) int age) {
		ModelAndView mv = new ModelAndView("mv"); // 뷰이름을 지정
		mv.addObject("name", name); // 데이터를 저장
		mv.addObject("age", age);
		return mv;
	}	
	
	@RequestMapping(value = "/board")
	@ResponseBody
	public String board( // 왕왕짜증이다.
			@RequestParam(defaultValue = "1", required = false) int p,
			@RequestParam(defaultValue = "10", required = false) int s,
			@RequestParam(defaultValue = "10", required = false) int b,
			@RequestParam(defaultValue = "-1", required = false) int idx
			) {
		return "<h1>" + p + ", " + b + ", " + s +", " + idx + "</h1>";
	}

	@RequestMapping(value = "/board2")
	@ResponseBody
	public String board2(@ModelAttribute CommVO cv) { // VO로 받는다.
		return "<h1>" + cv.getP() + ", " + cv.getB() + ", " + cv.getS() +", " + cv.getIdx() + "</h1>"
		 + "<h2>" + cv.getCurrentPage() + ", " + cv.getBlockSize() + ", " + cv.getPageSize() +", " + cv.getIdx() + "</h2>";
	}
	
	@RequestMapping(value = "/memoForm")
	public String memoForm() {
		return "memoForm";
	}
	
	@RequestMapping(value = "/insertOk", method = RequestMethod.GET)
	public String memoGet() {
		return "redirect:/memoForm"; // 무작정 이동!!!
	}

	@RequestMapping(value = "/insertOk", method = RequestMethod.POST)
	public String memoPost(@ModelAttribute CommVO cv, @ModelAttribute MemoVO memoVO, Model model) {
		model.addAttribute("cv", cv);
		model.addAttribute("mv", memoVO);
		return "insertOk"; 
	}
	
	@RequestMapping(value = "/mapForm")
	public String mapForm() {
		return  "mapForm";
	}
	// 맵으로 받기
	@RequestMapping(value = "/result")
	public String map(@RequestParam Map<String, String> map, @RequestParam(required = false) String[] d, Model model) {
		model.addAttribute("map", map);
		model.addAttribute("d", d);
		return "result";
	}
	
}
