<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main id="main" class="main">
	<div class="pagetitle">
		<h1>예약 이용내역</h1>
	</div>
	
	<section class="section">
		<div class="row">
			<div class="col-lg-12">
				<div class="card">
              		<div class="card-body">
                		<h5 class="card-title">Seat Used History</h5>
                		<c:if test="${not empty seatList}">
                		<table class="table">
                			<thead>
                    			<tr>
                      				<th scope="col">좌석번호</th>
                      				<th scope="col">시작일</th>
                      				<th scope="col">종료일</th>
                      				<th scope="col">상태</th>
                    			</tr>
                  			</thead>
                  			<tbody>
                  			<c:forEach items="${seatList}" var="sl">
                  				<tr>
                      				<td>${sl.seatId}</td>
                      				<td>${sl.startDate}</td>
                      				<td>${sl.endDate}</td>
                      				<td>${sl.state}</td>
                    			</tr>
                  			</c:forEach>
                  			</tbody>
                		</table>
                		</c:if>
                		<c:if test="${empty seatList}">
                			<h5>이용 내역이 없습니다.</h5>
                		</c:if>
                	</div>
                </div>
			
          	</div>
        </div>
	</section>
</main>
