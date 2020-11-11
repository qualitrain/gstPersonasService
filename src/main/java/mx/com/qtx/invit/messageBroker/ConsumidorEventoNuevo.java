package mx.com.qtx.invit.messageBroker;

import java.util.Date;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.qtx.IConsumidorMsgEvtosNuevos;
import mx.com.qtx.IGestorEmpleados;
import mx.com.qtx.gstnper.entidades.EventoAgendado;
import mx.com.qtx.util.FechaUtil;

public class ConsumidorEventoNuevo extends ConsumidorMensajes implements IConsumidorMsgEvtosNuevos{
	private static Logger bitacora = LoggerFactory.getLogger(ConsumidorEventoNuevo.class); 
	private IGestorEmpleados gestorEmpleados;

	public ConsumidorEventoNuevo(String host, String nomCola, String nomExchange, IGestorEmpleados gestorEmpleados) {
		super(host, nomCola, nomExchange);
		this.gestorEmpleados = gestorEmpleados;
		
		bitacora.info("ConsumidorEventoNuevo(" + host + ", " + nomCola + ", " + nomExchange + ") instanciado");
	}

	@Override
	public void procesarMensajeJson(String mensaje) {
		Jsonb jsonb = JsonbBuilder.create();
		EventoPropuestoDTO evento = jsonb.fromJson(mensaje, EventoPropuestoDTO.class);
		Date fechaFin = FechaUtil.agregarMinutosAFecha(evento.getFechaProg(),evento.getDuracionProgMin());
		for(ParticipanteEventoDTO participanteI : evento.getParticipantes()) {
			EventoAgendado evtI = new EventoAgendado();
			evtI.setNumEmpleado(participanteI.getNumEmpleado());
			evtI.setEstado(0);
			evtI.setInicioProg(evento.getFechaProg());
			evtI.setFinProg(fechaFin);
			evtI.setTipo(5);
			this.gestorEmpleados.agregarEventoAgendado(evtI);
		}
	}
	
	public void consumirMensajes() {
		super.consumirMensajes();
		bitacora.info("Recuperación de mensajes en segundo plano activa. Id(Consumer tag)=" + this.idConsumidor);		
	}

}
