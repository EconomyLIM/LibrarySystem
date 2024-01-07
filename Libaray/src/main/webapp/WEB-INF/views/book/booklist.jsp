<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="main" class="main">
      <div class="pagetitle">
        <h1>도서</h1>
      </div>
      <!-- End Page Title -->

      <section class="section">
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <h5 class="card-title">Book List</h5>
                <div class="row">
                  <div class="col-sm-8"></div>
                  <div class="col-sm-2"></div>

                </div>
                <!-- Table with stripped rows -->
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">도서ID</th>
                      <th scope="col">도서이름</th>
                      <th scope="col">글쓴이</th>
                      <th scope="col">남은 수량</th>
                      <th scope="col">대여</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:if test="${not empty booklist }">
                  	<c:forEach items="${booklist}" var="book">
                  	<tr>
                      <td>${book.bookId}</td>
                      <td>${book.bookName}</td>
                      <td>${book.bookWriter}</td>
                      <td>${book.bookCount}</td>
                      <td><button type="button" class="btn btn-outline-primary btn-sm" onclick="bookRent(${book.bookId});">대여</button></td>
                    </tr>
                  	</c:forEach>
                  </c:if>

                  </tbody>
                </table>
                <!-- End Table with stripped rows -->
              </div>
              <nav aria-label="Page navigation example">
                <ul class="pagination justify-content-center">
                  <li class="page-item disabled">
                    <a
                      class="page-link"
                      href="#"
                      tabindex="-1"
                      aria-disabled="true"
                      >Previous</a
                    >
                  </li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a></li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </section>
    </main>
    <script>
    function bookRent(bookId) {
		
		$.ajax({
			
			url : '/book/'+bookId,
			method: 'post',
			beforeSend: function(xhr) {
				xhr.setRequestHeader("${_csrf.headerName}","${_csrf.token}");
			},
			cache:false,
			contentType: 'application/json; charset=utf-8',
			success: function(response) {
				alert(response.responseText);
				window.location.href ='/book'
			},
			error: function(response) {
				alert(response.responseText);
				window.location.href ='/book?error'
			}
		}); // ajax
		
	} // bookRent
    </script>
    <!-- End #main -->