package mx.com.qtx.gstnper.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import mx.com.qtx.gstnper.entidades.Empleado;

@Service
public class GestorEmpleados {
	private static Map<Integer,Empleado> mapEmpleados = obtenerEmpleados();

	private static Map<Integer, Empleado> obtenerEmpleados() {
		Map<Integer,Empleado> empleados = new HashMap<>();
		
		Empleado emp = new Empleado(2000,"Jorge","Villasana","Rodríguez","77-23-43-11-11","jvillasana@laempresa.com.mx","DG","Director General");
		empleados.put(emp.getNumEmpleado(), emp);
		
		emp = new Empleado(2120,"Marina","Roldán","Aguirre","77-11-55-11-36","mroldan@laempresa.com.mx","DVTAS","Director");
		empleados.put(emp.getNumEmpleado(), emp);
		
		emp = new Empleado(2100,"Violeta","Jara","Romo","77-13-45-19-22","vjara@laempresa.com.mx","DTI","Director");
		empleados.put(emp.getNumEmpleado(), emp);
		
		emp = new Empleado(2102,"Roberto","Corona","Díaz","55-99-71-44-13","rcorona@laempresa.com.mx","DPLN","Director");
		empleados.put(emp.getNumEmpleado(), emp);
		
		emp = new Empleado(1667,"Juan Carlos","Herrera","Luna","22-34-71-77-19","jcherrera@laempresa.com.mx","DOPER","Director");
		empleados.put(emp.getNumEmpleado(), emp);
		
		emp = new Empleado(501,"José Miguel","Torres","Aragón","55-11-34-11-22","jmtorres@laempresa.com","DOPER","Coordinado de Area");
		empleados.put(emp.getNumEmpleado(), emp);
		
		emp = new Empleado(3421,"Mariana","Valdés","Forlán","77-12-33-91-45","mvaldes@laempresa.com","DOPER","Analista Sr");
		empleados.put(emp.getNumEmpleado(), emp);
		
		emp = new Empleado(552,"Juan Manuel","Tinoco","Morales","33-19-99-01-03","jmtinoco@laempresa.com","DOPER","Consultor");
		empleados.put(emp.getNumEmpleado(), emp);
		
		return empleados;
	}
	
	public List<Empleado> getEmpleados(){
		return new ArrayList<>( mapEmpleados.values() );
	}
	
	
}
