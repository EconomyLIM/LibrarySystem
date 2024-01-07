<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!-- ======= Header ======= -->
    <header id="header" class="header fixed-top d-flex align-items-center">
      <div class="d-flex align-items-center justify-content-between">
        <a href="index.html" class="logo d-flex align-items-center">
          <img src="assets/img/logo.png" alt="" />
          <span class="d-none d-lg-block">통합 예약 시스템</span>
        </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
      </div>
      <!-- End Logo -->

      <div class="search-bar">
        <form
          class="search-form d-flex align-items-center"
          method="POST"
          action="#"
        >
          <input
            type="text"
            name="query"
            placeholder="Search"
            title="Enter search keyword"
          />
          <button type="submit" title="Search">
            <i class="bi bi-search"></i>
          </button>
        </form>
      </div>
      <!-- End Search Bar -->

      <nav class="header-nav ms-auto">
        <ul class="d-flex align-items-center">
          <li class="nav-item" style="list-style-type: none">
            <button type="button" id="signInBtn" class="btn btn-light mb-2" onclick="window.location.href='/signin';">
              Sign In
            </button>
          </li>
          <sec:authorize access="isAnonymous()"> 
          <li class="nav-item" style="list-style-type: none">
            <button type="button" id="logInBtn" class="btn btn-light mb-2" onclick="window.location.href='/login';">
              Log In
            </button>
          </li>
          </sec:authorize>
		 <sec:authorize access="isAuthenticated()">
          <li class="nav-item" style="list-style-type: none">
            <button type="button" id="logOutBtn" class="btn btn-light mb-2" onclick="logout();">
              Log Out
            </button>
          </li>
          <script>
          function logout(){
        	       let f = document.createElement('form');

        	      let obj;
        	      obj = document.createElement('input');
        	      obj.setAttribute('type', 'hidden');
        	      obj.setAttribute('name', '${_csrf.parameterName }');
        	      obj.setAttribute('value', '${_csrf.token }');
        	      
        	      f.appendChild(obj);
        	      f.setAttribute('method', 'post');
        	      f.setAttribute('action', '/logout');
        	      document.body.appendChild(f);
        	      f.submit();

        	  }

          </script>
          
          </sec:authorize>
          
           <sec:authorize access="isAuthenticated()">
          <li class="nav-item d-block d-lg-none">
            <a class="nav-link nav-icon search-bar-toggle" href="#">
              <i class="bi bi-search"></i>
            </a>
          </li>
          <!-- End Search Icon-->

          <li class="nav-item dropdown pe-3">
            <a
              class="nav-link nav-profile d-flex align-items-center pe-0"
              href="#"
              data-bs-toggle="dropdown"
            >
              <!-- <img
                src="assets/img/profile-img.jpg"
                alt="Profile"
                class="rounded-circle"
              /> -->
              <span class="d-none d-md-block dropdown-toggle ps-2" >
             	<sec:authentication property="principal.loginUserDTO.studentName"/>
              </span> </a>
            <!-- End Profile Iamge Icon -->

            <ul
              class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile"
            >
              <li class="dropdown-header">
                <h6><sec:authentication property="principal.loginUserDTO.studentName"/></h6>
                <!-- <span>Web Designer</span> -->
              </li>
              <li>
                <hr class="dropdown-divider" />
              </li>

              <li>
                <a
                  class="dropdown-item d-flex align-items-center"
                  href="users-profile.html"
                >
                  <i class="bi bi-person"></i>
                  <span>My Profile</span>
                </a>
              </li>
              <li>
                <hr class="dropdown-divider" />
              </li>

              <li>
                <a
                  class="dropdown-item d-flex align-items-center"
                  href="users-profile.html"
                >
                  <i class="bi bi-gear"></i>
                  <span>Account Settings</span>
                </a>
              </li>
              <li>
                <hr class="dropdown-divider" />
              </li>

              <li>
                <a
                  class="dropdown-item d-flex align-items-center"
                  href="pages-faq.html"
                >
                  <i class="bi bi-question-circle"></i>
                  <span>Need Help?</span>
                </a>
              </li>
              <li>
                <hr class="dropdown-divider" />
              </li>

              <li>
                <a class="dropdown-item d-flex align-items-center" href="#">
                  <i class="bi bi-box-arrow-right"></i>
                  <span>Sign Out</span>
                </a>
              </li>
            </ul>
            <!-- End Profile Dropdown Items -->
          </li>
          <!-- End Profile Nav -->
           </sec:authorize>
        </ul>
      </nav>
      <!-- End Icons Navigation -->
    </header>
    <!-- End Header -->