package mx.com.qtx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import mx.com.qtx.invit.messageBroker.ConsumidorEventoNuevo;

@SpringBootApplication
public class GstPersonasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GstPersonasServiceApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public IConsumidorMsgEvtosNuevos getConsumidorMensajes(Environment env, IGestorEmpleados gestorEmpleados) {
		IConsumidorMsgEvtosNuevos consumMessageBroker = new ConsumidorEventoNuevo(
				env.getProperty("qtx.gstnper.messageBroker.host", "localhost"),
				env.getProperty("qtx.gstnper.messageBroker.nomColaEvtos", "colaEventosDefault"),
				env.getProperty("qtx.gstnper.messageBroker.exchangeEvtos", "exchangeDefault"),
				gestorEmpleados
				);
		consumMessageBroker.suscribirseAexchangeConfig();
		consumMessageBroker.consumirMensajes();
		return consumMessageBroker;
		
	}

}
