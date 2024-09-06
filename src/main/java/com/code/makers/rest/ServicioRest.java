package com.code.makers.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.code.makers.dominio.Articulo;
import com.code.makers.persistencia.GestorDatos;

@Path("articulo")
public class ServicioRest {

	private static GestorDatos gd = new GestorDatos();

	@GET
	@Path("/txt")
	@Produces(MediaType.TEXT_PLAIN + "; charset=UTF-8")
	public String getArticuloPorIdTxt(@QueryParam("clave") String clave) {
		Articulo artI = gd.leerArticulo(clave);
		if (artI == null) {
			return "No existe";
		}
		return artI.toString();
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Articulo getArticuloPorIdJson(@QueryParam("clave") String clave) {
		return gd.leerArticulo(clave);
	}

	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML + "; charset=UTF-8")
	public Articulo getArticuloPorIdXml(@QueryParam("clave") String clave) {
		return gd.leerArticulo(clave);
	}

	@GET
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Articulo getArticuloPorId(@DefaultValue("Indefinido") @QueryParam("clave") String clave) {
		if (clave.equals("Indefinido")) {
			return null;
		}
		return gd.leerArticulo(clave);
	}

	@GET
	@Path("inventario")
	@Produces(MediaType.APPLICATION_JSON)
	public int getTotalArticulos() {
		return gd.getTotalArticulos();
	}

	@POST
	@Path("/insertar")
	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	public Response agregarArticulo(Articulo articulo) {
		boolean guardado = gd.insertarArticulo(articulo);

		if (guardado) {
			return Response.status(Response.Status.CREATED).entity(articulo).build();
		} else {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error al guardar el artículo")
					.build();
		}
	}

	@GET
	@Path("/listar")
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response listarArticulos() {
		return Response.status(Response.Status.OK).entity(gd.obtenerArticulos()).build();
	}

	@DELETE
	@Path("/{id}")
	@Produces({ MediaType.TEXT_XML, MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response eliminarArticulo(@PathParam("id") String clave) {
		Articulo articulo = gd.eliminarArticulo(clave);
		if (articulo != null) {
			return Response.ok().entity(articulo.toString()).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Artículo no encontrado con la clave: " + clave)
					.build();
		}
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response actualizarArticulo(@PathParam("id") String clave, Articulo articuloActualizado) {
		boolean exito = gd.actualizarArticulo(clave, articuloActualizado);

		if (exito) {
			return Response.ok().entity(articuloActualizado).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Artículo no encontrado con la clave: " + clave)
					.build();
		}
	}

	public static void main(String[] args) {

		// ServicioRest sr= new ServicioRest();
		// System.out.println(sr.getArticuloPorId("001"));
		// System.out.println(sr.getArticuloPorId("0099"));
	}

}
