function init() {

	// http://jquery-howto.blogspot.ca/2009/09/get-url-parameters-values-with-jquery.html
	function getUrlVars()
	{
		var vars = [], hash;
		var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
		for(var i = 0; i < hashes.length; i++)
		{
			hash = hashes[i].split('=');
			vars.push(hash[0]);
			vars[hash[0]] = hash[1];
		}
		return vars;
	}

	var vars = getUrlVars();

	if (vars['message'] == 'login-required') {
		setTimeout(function() {
			$('.signin').click();
		}, 500);
	} else if(vars['action'] == 'reset-password') {
		$('#overlay').show(0, function() {
			$('#overlay').css('opacity', 0.9);
		});
		$('.resetModal').show(0, function() {
			$('.resetModal').css('opacity', 1);
		});
		$('.resetModal #code').val(vars['code']);
	}


	$('.activateOverlay').on('click', function(ev) {
		ev.preventDefault();

		$('#overlay').show(0, function() {
			$('#overlay').css('opacity', 0.9);
		});
		$('.loginModal').show(0, function() {
			$('.loginModal').css('opacity', 1);
		});
	});

	$('.cancelModal').on('click', function(ev) {
		ev.preventDefault();
		$('#overlay').css('opacity', 0);

		setTimeout(function() {
			$('#overlay').hide();
		}, 330);

		hideLoginModal();
		hideResetModal();
	});

	function hideLoginModal() {
		$('.loginModal').css('opacity', 0);
		setTimeout(function() {
			$('.loginModal').hide();
		}, 330);
	}

	function hideResetModal() {
		$('.passwordResetModal').css('opacity', 0);
		$('.resetModal').css('opacity', 0);
		setTimeout(function() {
			$('.passwordResetModal,.resetModal').hide();
		}, 330);
	}

	$('.signin').on('click', function(ev) {
		$('.loginModal .submit').html('Login');
		$('.loginModal .modal-message').html('登录你的账户');
		$('#loginForm').attr('action', 'login.action');
		$('.loginModal .submit').attr('mode', 'login');
		$('.readtos').hide();
		$('.passwordReset').show();
	});
	
	$('.register').on('click', function(ev) {
		$('.loginModal .submit').html('Register');
		$('#loginForm').attr('action', './register');
		$('.loginModal .submit').attr('mode', 'register');
		$('.loginModal .modal-message').html('创建一个志愿者账户');
		$('.readtos').show();
		$('.passwordReset').hide();
	});

	$('.passwordReset').on('click', function() {
		hideLoginModal();
		$('.passwordResetModal').show(0, function() {
			$('.passwordResetModal').css('opacity', 1);
		});

	});

	$('.gotoPricing').on('click', function(ev) {
		ev.preventDefault();
		window.scrollTo(0, 5000);
	});

	$('.logo').on('click', function(ev) {
		ev.preventDefault();
		window.scrollTo(0, 0);
	});
}

$(document).ready(function() {
	init();

	var failLogin = location.href.indexOf('logged_in=false') !== -1;

	if (failLogin) {
		$('.signin').click();
		$('.loginModal .modal-message').html('登录失败');
	}
});


var app = {};
app.alert = function (params) {
	var alert_id = 'alert_button_' + ((params.alert_id) ? params.alert_id : new Date().getTime());

	var alert = $('#' + alert_id);
	var title = params.title || '';

	function startTimeout(div, timeout) {
		var timeoutId = setTimeout(function () {
			$(div).fadeOut(1000, function () {
				$(this).remove();
			});
		}, timeout);

		$(div).attr('timeoutId', timeoutId);
	}

	if (alert.length > 0) {
		alert.find('strong').html(title);
		alert.find('p').html(params.message);
		alert.attr('class', "alert toaster-alert " + "alert-" + params.type);

		clearTimeout(alert.attr('timeoutId'));
		startTimeout(alert, params.timeout);
	} else {
		var div = document.createElement('div'),
			button = document.createElement('button'),
			strong = document.createElement('strong'),
			p = document.createElement('p');

		p.innerHTML = params.message;
		strong.innerHTML = title;

		div.className = "alert toaster-alert " + "alert-" + params.type;

		div.setAttribute('id', alert_id);
		div.appendChild(button);
		div.appendChild(strong);
		div.appendChild(p);

		button.className = 'close';
		button.innerHTML = '&times;';
		button.onclick = function (ev) {
			div.parentNode.removeChild(div);
		}

		if (params.location == null)
			params.location = 'alert_window';

		jQuery('#' + params.location).prepend(jQuery(div).fadeIn('100'));

		if (params.timeout) {
			startTimeout(div, params.timeout);
		}

		if (params.clickfn) {
			div.onclick = function () {
				params.clickfn();
				jQuery(div).fadeOut(500, function () {
					this.remove();
				});
			}
		}
	}
}


$(document).ready(function() {
	var	submitBtn = $('.loginModal .submit'),
		emailEl = document.getElementById('email'),
		passwordEl = document.getElementById('password'),
		readTos = document.getElementById('readtos'),
		emailCheck = /.+@.*\.[\w]{2,6}/,
		errors = false;

	$('#loginForm input').keypress(function(e) {
		if (e.which == 13) {
			submitBtn.trigger('click');
		}
	});

	function showError(text, title) {
		errors = true;
		if(!title)
			title = 'Error';

		app.alert({
			'alert_id': 'error_alert',
			type: 'danger',
			title: title,
			message: text,
			timeout: 5000
		});
	}
	submitBtn.on('click', function(e) {

		if (submitBtn.attr('mode') === 'login') {
			document.getElementById('loginForm').submit();
			return;
		}

		errors = false;

		if (!readTos.checked) {
			showError('必须接受协议');
			return false;
		}

		if (!emailCheck.test(emailEl.value)) {
			showError('请输入一个有效的邮箱');
			return false;
		} else if (passwordEl.value.length < 6) {
			showError('密码至少六位');
			return false;
		}

		jQuery.post("./api/checkemail", {email: emailEl.value, _csrf: document.getElementById('csrf').value})
			.done(function(data) {
				if (data.status === false) {
					showError('账户已存在');
				} else {
					if (errors === false) {
						document.getElementById('loginForm').submit();
					}
				}
			});
	});

	$('.passwordResetModal .submit').on('click', function() {

		jQuery.post("./api/resetpassword", {email: $('.passwordResetModal .email').val(), _csrf: document.getElementById('csrf').value})
			.done(function(data) {
				if (data.status === false) {
					showError('账户不存在');
				} else {
					app.alert({
						'alert_id': 'error_alert',
						type: 'success',
						title: 'Email sent',
						message: '已经发送邮件',
						timeout: 5000
					});
					$('.cancelModal').trigger('click');
				}
			});
	});


	$('.resetModal .submit').on('click', function() {
		var password = $('.resetModal #password').val();
		var passwordAgain = $('.resetModal #passwordAgain').val();

		if(password !== passwordAgain) {
			return app.alert({
				'alert_id': 'error_alert',
				type: 'danger',
				title: 'Error',
				message: '密码不匹配',
				timeout: 5000
			});
		}

		jQuery.post("/reset/commit",
			{
				code: $('.resetModal #code').val(),
				password: password,
				_csrf: document.getElementById('csrf').value
			})
			.done(function(data) {
				if(data.redirect)
					window.location = data.redirect;

				if(data.message) {
					if(data.success) {
						app.alert({
							'alert_id': 'success_alert',
							type: 'success',
							title: 'Email sent',
							message: data.message,
							timeout: 5000
						});
					} else {
						app.alert({
							'alert_id': 'error_alert',
							type: 'danger',
							title: 'Error',
							message: data.message,
							timeout: 5000
						});
					}
				}
			})
	});

});
