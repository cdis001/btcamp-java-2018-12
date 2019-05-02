if (window.localStorage.getItem('email')) {
	//document.querySelector('#email').value = window.localStorage.getItem('email')
	document.querySelector('#email').value = window.localStorage.email
}

document.querySelector('#login-btn').onclick = () => {
	var xhr = new XMLHttpRequest()
	  xhr.onreadystatechange = function() {
	    if (xhr.readyState != 4 || xhr.status != 200)
	      return;
	    
	    var data = JSON.parse(xhr.responseText);
	    
	    if(data.status == 'success') {
	    	location.href = "../index.html"
	    } else {
	    	alert('로그인 실패입니다!\n' + data.message)
	    }
	  };
	  xhr.open('POST', '../../app/json/auth/login', true)
	  xhr.setRequestHeader('ConTent-Type', 'application/x-www-form-urlencoded')
	  var email = document.querySelector('#email').value;
	  var password = document.querySelector('#password').value;
	  
	  if(document.querySelector('#saveEmail:checked') != null){
		  //window.localStorage.setItem("email", email);
		  window.localStorage.email = email;
	  } else {
		  window.localStorage.removeItem("email");
	  }
	  
	  var qs = 'email=' + email + '&password=' + password;
	  xhr.send(qs);
};

function setCookie(name, value, expireDays) {
	  var today = new Date();
	  today.setTime(today.getTime() + expireDays * 24 * 60 * 60 * 1000);
	  
	  document.cookie = name + '=' + value + 
	    ';expires=' + today.toUTCString() + 
	    ';path=/';
}