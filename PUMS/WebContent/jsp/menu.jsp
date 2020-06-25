<%@page import="java.util.Calendar"%>

<header class="mdl-layout__header">
	<div class="mdl-layout__header-row">

		<span class="mdl-layout-title"> Personal User Management System</span>

		<div class="mdl-layout-spacer"></div>

		<nav class="mdl-navigation mdl-layout--large-screen-only">
			<a class="mdl-navigation__link" href="/PUMS/UserController?op=new">Add new user</a> <a
				class="mdl-navigation__link" href="/PUMS/UserController?op=list">List new user</a>
		</nav>
	</div>
</header>

<div class="mdl-layout__drawer">
	<span class="mdl-layout-title">PUMS</span>
	<nav class="mdl-navigation">
		<a class="mdl-navigation__link" href="/PUMS/UserController?op=new">Add new user</a> <a
			class="mdl-navigation__link" href="/PUMS/UserController?op=list">List all user</a>

	</nav>
</div>