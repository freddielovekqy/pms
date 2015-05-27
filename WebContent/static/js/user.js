$(function() {
  $(".form-control").blur(function() {
    if ($(this).val() == "") {
      $(this).parent().addClass("has-error");
      $(this).next().addClass("glyphicon-remove");
    }
  });

  $(".form-control").focus(function() {
    if ($(this).attr("id") == "password") {
      $(this).attr("placeholder", "请输入密码");
    }
    $(this).parent().removeClass("has-error");
    $(this).next().removeClass("glyphicon-remove");
  });

  $(".btn-link").click(function() {
    location.href = "../user/register";
  });

  $(".loginButton").click(function() {
    location.href = "../user/login";
  });

  $("#reset").click(function() {
    $(".form-control").val("");
  });

  $("#register").click(function() {
    var email = $("#email").val();
    var name = $("#name").val();
    var password = $("#password").val();

    if (!email.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
      $("#email").parent().addClass("has-error");
      $("#email").next().addClass("glyphicon-remove");
      return;
    } else if (password.length < 6 || password.length > 14) {
      $("#password").parent().addClass("has-error");
      $("#password").next().addClass("glyphicon-remove");
      return;
    }

    $.ajax({
      type: "post",
      url: "../user/saveUser",
      data: {
        "email": email,
        "name": name,
        "password": password
      },
      success: function(data) {
        if (data.status == 1) {
          location.href = "../project/showProjectList";
        } else {
          alert(data.returnMessage);
        }
      }
    });
  });

  $(".btn.btn-primary").click(function() {
    var email = $("#email").val();
    var password = $("#password").val();

    if (email == "" || password == "") {
      $(".form-control").parent().addClass("has-error");
      $(".form-control").next().addClass("glyphicon-remove");
      return;
    }

    $.ajax({
      type: "post",
      url: "../user/checkUser",
      data: {
        "email": email,
        "password": password
      },
      success: function(data) {
        if (data == "") {
          $("#password").val("");
          $("#password").attr("placeholder", "密码输入错误");
          $("#password").parent().addClass("has-error");
          $("#password").next().addClass("glyphicon-remove");
        } else {
          var user = data;
          location.href = "../project/showProjectList";
        }
      }
    });
  });

});