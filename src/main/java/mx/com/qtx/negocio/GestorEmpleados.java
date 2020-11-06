package mx.com.qtx.negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import mx.com.qtx.entidades.Empleado;

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
		
		return empleados;
	}
	
	public List<Empleado> getEmpleados(){
		return new ArrayList<>( mapEmpleados.values() );
	}
	
	
}
