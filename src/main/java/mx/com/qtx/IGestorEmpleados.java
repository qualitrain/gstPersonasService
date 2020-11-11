package mx.com.qtx;

import java.util.List;

import mx.com.qtx.gstnper.entidades.Empleado;
import mx.com.qtx.gstnper.entidades.EventoAgendado;

public interface IGestorEmpleados {
	List<Empleado> getEmpleados();
	Empleado getEmpleado(int numEmpleado);
	List<EventoAgendado> getEventosEmpleado(int numEmpleado);
	void agregarEventoAgendado(EventoAgendado evtI);
}
