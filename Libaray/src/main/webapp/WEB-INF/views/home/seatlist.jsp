<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

      <c:if test="${not empty seats}">
      	<c:forEach var="i" varStatus="outerLoop" begin="1" end="4">
      		<div class="row">
      		
      		<c:set var="innerLoopBegin" value="${(outerLoop.index - 1) * 4}" />
			<c:set var="innerLoopEnd" value="${(outerLoop.index * 4) -1}" />
			
			<c:forEach items="${seats}" var="sts" begin="${innerLoopBegin}" end="${innerLoopEnd}">
			<div  class="col-lg-3">
			<div class="card">
              <div class="card-body">
                <h5 class="card-title">${sts.seatName}</h5>
                <c:if test="${not empty sts.endDate}">
                	<p>${sts.startDate}</p>
                	<p>~${sts.endDate}</p>
                	<c:if test="${sts.mine}">
                		<button
                  type="button"
                  id="signInBtn"
                  class="btn btn-light mb-2"
                  data-bs-toggle="modal"
                  data-bs-target="#extension"
                >
                  연장
                </button>
                <div
                  class="modal fade"
                  id="extension"
                  tabindex="-1"
                  style="display: none"
                  aria-hidden="true"
                >
                  <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title">알람</h5>
                        <button
                          type="button"
                          class="btn-close"
                          data-bs-dismiss="modal"
                          aria-label="Close"
                        ></button>
                      </div>
                      <div class="modal-body">
                        (2시간) 연장하시겠습니까?
                      </div>
                      <div class="modal-footer">
                        <button
                          type="button"
                          class="btn btn-secondary"
                          data-bs-dismiss="modal"
                        >
                          Close
                        </button>
                        <button type="button" class="btn btn-primary" data-seq="${sts.connectionseq}" id="extensionBtn">
                          연장
                        </button>
                        <script>
                        $(function() {
							$('#extensionBtn').on('click', function() {
								
								var connectionseq = $(this).data('seq');
								
								$.ajax({
									
									url:"/seat/"+connectionseq,
									method: "put",
									cache: false,
									beforeSend: function(xhr) {
										xhr.setRequestHeader("${_csrf.headerName}","${_csrf.token}");
									},
									success: function(data) {
										alert(data);
										window.location.href = "/";
									}, 
									error: function() {
										alert('연장실패 (서버 오류)');
									}
								}) // ajax close
								
							}) // click func
						}); // ready func
                        </script>
                      </div>
                    </div>
                  </div>
                </div>
                <button type="button" id="signInBtn" class="btn btn-light mb-2" data-bs-toggle="modal" data-bs-target="#return" >
                  반납
                </button>
                <div
                  class="modal fade"
                  id="return"
                  tabindex="-1"
                  style="display: none"
                  aria-hidden="true"
                >
                  <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                      <div class="modal-header">
                        <h5 class="modal-title"></h5>
                          <i class="bi bi-check-lg"></i>
                          경고
                        </h5>
                        <button
                          type="button"
                          class="btn-close"
                          data-bs-dismiss="modal"
                          aria-label="Close"
                        ></button>
                      </div>
                      <div class="modal-body">진짜 반납 하시겠습니까?</div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                          Close
                        </button>
                        <button type="button" class="btn btn-primary" data-seq="${sts.connectionseq}" id="returnBtn">
                          반납
                        </button>
                        <script>
                        	$(function() {
								$('#returnBtn').on('click', function() {
									
									var connectionseq = $(this).data('seq');
									
									$.ajax({
										
										url:"/seat/"+connectionseq,
										method: "delete",
										cache: false,
										beforeSend: function(xhr) {
											xhr.setRequestHeader("${_csrf.headerName}","${_csrf.token}");
										},
										success: function(data) {
											alert(data);
											window.location.href = "/";
										}, 
										error: function() {
											alert('반납실패 (서버 오류)');
										}
									}) // ajax close
									
								}) // click func
							}); // ready func
                        </script>
                      </div>
                    </div>
                  </div>
                </div>
                	</c:if>
                </c:if>
                <c:if test="${empty sts.endDate }">
                <input class="form-check-input" type="radio" name="seatId" id="${sts.seatId}" value="${sts.seatId}"/>
                <label class="form-check-label" for="${sts.seatId}">
                  ${sts.seatName}
                </label>
                </c:if>
              </div>
            </div>
			</div>
			</c:forEach>
			
			</div>
      	</c:forEach>
      
      </c:if>

      