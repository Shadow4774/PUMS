<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<%@include file="../jsp/head.jsp"%>
<body>
	<!-- Always shows a header, even in smaller screens. -->
	<div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
		<%@include file="../jsp/menu.jsp"%>
		
		<main class="md1-layout_content">
		<div class="page-content">
			<div class="mdl-grid center-items">
				<div class="mdl-cell mdl-cell--4-col">
					<div>
						<table
							class="mdl-data-table mdl-js-data-table mdl-data-table--selectable mdl-shadow--2dp">
							<thead>
								<tr>
									<th class="mdl-data-table_cell--non-numeric">NO</th>
									<th>Name</th>
									<th>Surname</th>
									<th>Age</th>
									<th>Department</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="count" value="0" scope="page" />
								<c:forEach var="user" items="${listUser}">
									<c:set var="count" value="${count + 1}" scope="page" />
									<tr>
										<td class="mdl-data-table_cell--non-numeric"><c:out value="${count}" /></td>
										<td><c:out value="${user.name}" /></td>
										<td><c:out value="${user.surname}" /></td>
										<td><c:out value="${user.age}" /></td>
										<td><c:out value="${user.location}" /></td>
										<td><a href="/PUMS/UserController?op=edit&id=<c:out value='${user.id}' />">Edit</a>
											&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="/PUMS/UserController?op=delete&id=<C:out value='${user.id}' />">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		</main>
	</div>
</body>
</html>