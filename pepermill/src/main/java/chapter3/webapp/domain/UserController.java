package chapter3.webapp.domain;

import chapter3.webapp.web.annotation.GetMapping;
import chapter3.webapp.web.annotation.PostMapping;
import chapter3.webapp.domain.model.User;
import chapter3.webapp.web.HttpStatusCode;
import chapter3.webapp.web.RequestForm;
import chapter3.webapp.web.View;

public class UserController {

	private final UserService userService;

	public UserController(final UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/index.html")
	public View home() {
		View view = new View();
		view.setHttpStatusCode(HttpStatusCode.OK.getHttpStatusCode());
		return view;
	}

	@GetMapping("/user/login.html")
	public View home(RequestForm form) {
		User user = userService.login(form.getName(), form.getPassword());
		View view = new View();
		view.setHttpStatusCode(HttpStatusCode.OK.getHttpStatusCode());
		// view.setCookie("login=true");
		return view;
	}

	@GetMapping("/user/form.html")
	public View registerGet(RequestForm form) {
		userService.registerUser(form.getName(), form.getPassword());
		View view = new View();
		view.setHttpStatusCode(HttpStatusCode.FOUND.getHttpStatusCode());
		view.setHttpStatusDescription(HttpStatusCode.FOUND.getHttpStatusDescription());
		view.setLocation("/index.html");
		return view;
	}

	@PostMapping("/user/form.html")
	public View registerPost(RequestForm form) {
		userService.registerUser(form.getName(), form.getPassword());
		View view = new View();
		view.setHttpStatusCode(HttpStatusCode.FOUND.getHttpStatusCode());
		view.setHttpStatusDescription(HttpStatusCode.FOUND.getHttpStatusDescription());
		view.setLocation("/index.html");
		return view;
	}
}