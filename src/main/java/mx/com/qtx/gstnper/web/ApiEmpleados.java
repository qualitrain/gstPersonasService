package mx.com.qtx.gstnper.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mx.com.qtx.IGestorEmpleados;
import mx.com.qtx.gstnper.entidades.Empleado;
import mx.com.qtx.gstnper.entidades.EventoAgendado;

import java.util.List;

@RestController
public class ApiEmpleados {
	@Autowired
	private IGestorEmpleados gestorEmpleados;
	
	@GetMapping(path = "/empleados", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Empleado> getEmpleados(){
		return gestorEmpleados.getEmpleados();
	}
	@GetMapping(path="/empleados/{numEmpleado}/eventos")
	public List<EventoAgendado> getEventosAgendadosEmpleado(@PathVariable int numEmpleado){
		return this.gestorEmpleados.getEventos(numEmpleado);
	}
	@GetMapping(path="/empleados/{numEmpleado}")
	public Empleado getEmpleado(@PathVariable int numEmpleado) {
		return this.gestorEmpleados.getEmpleado(numEmpleado);
	}

}
