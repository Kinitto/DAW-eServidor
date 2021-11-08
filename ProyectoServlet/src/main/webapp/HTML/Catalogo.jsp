<!DOCTYPE html>
<html>
<link rel="stylesheet" href="style.css">
<body>
<form action="/ProyectoServlet/servletCatalogo" method="post">
	<div class="section">
		<div class="cards">
			<div class="new-producto">
				<h1>Hooders.</h1>
			</div>
			<div class="card">
				<div class="image-section">
					<img src="camiseta.jpg">
				</div>
				<div class="description">
					<h1>Camiseta</h1>
					<p><b>Precio-</b><span>15€</span></p>
				</div>
				<div class="button-group">
					Cantidad: <input type="number" name="cantidad" class="cantidad" value="0">
				</div>
			</div>
			<div class="card">
				<div class="image-section">
					<img src="camiseta.jpg">
				</div>
				<div class="description">
					<h1>Pantalon</h1>
					<p><b>Precio</b><span>25€</span></p>
				</div>
				<div class="button-group">
					Cantidad: <input type="number" name="cantidadp2" class="cantidad" value="0">
				</div>
			</div>
			<div class="card">
				<div class="image-section">
					<img src="camiseta.jpg">
				</div>
				<div class="description">
					<h1>Abrigo</h1>
					<p><b>Precio</b><span>65€</span></p>
				</div>
				<div class="button-group">
					Cantidad: <input type="number" name="cantidadp3" class="cantidad" value="0">
				</div>
			</div>
			
		</div>
		
		
		<input type="submit" value="Ver pedido" class="boton">
		
	</div>
	
	</form>

</body>

</html>