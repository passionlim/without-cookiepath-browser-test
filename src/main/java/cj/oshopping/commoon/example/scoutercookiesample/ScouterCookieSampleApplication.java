package cj.oshopping.commoon.example.scoutercookiesample;

import java.util.Random;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ScouterCookieSampleApplication {
	private static Random random = new Random(System.currentTimeMillis());
	
	@RestController
	public static class MainController {
		@RequestMapping("/")
		public String index() {
			return "OK";
		}
		
	}
	
	@Controller
	public static class PageController {
		
		private static final int aYear = 365 * 60 * 60;

		@RequestMapping("/my/frame")
		public String frame(HttpServletRequest req, Model model) {
			return "frame";
		}
		
		@RequestMapping("/redirect/**/*")
		public String redirect(HttpServletRequest req, HttpServletResponse res, @CookieValue(value="_PERSIST", required=false) Cookie persistentCookie, Model model) {
			
			HttpSession submittedSession = req.getSession(false);
			HttpSession currentSession = req.getSession(true);
			
			if ( StringUtils.equals(System.getProperty("cookie"), "1") && persistentCookie == null ) {
				Cookie cookie = new Cookie("_PERSIST", Long.toHexString(random.nextLong()));
				 String path= System.getProperty("path");
				 
				if ( StringUtils.isNotBlank(path) ) {
					cookie.setPath(path);
				}
				cookie.setMaxAge(aYear);
				res.addCookie(cookie);
			}
			
			model.addAttribute("previousSessionId", req.getParameter("previousId") != null ? req.getParameter("previousId"):"" );
			model.addAttribute("submittedSessionId", submittedSession != null ? submittedSession.getId():"" );
			model.addAttribute("currentSessionId", currentSession != null ? currentSession.getId():"" );
			
			return "form";
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ScouterCookieSampleApplication.class, args);
	}
}
