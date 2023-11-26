package cajero.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cajero.modelo.dao.CuentaDao;
import cajero.modelo.dao.MovimientoDao;
import cajero.modelo.entity.Cuenta;
import cajero.modelo.entity.Movimiento;
import jakarta.servlet.http.HttpSession;

@Controller
public class TransaccionesController {
	
	@Autowired
	private CuentaDao cuentaDao;
	
	@Autowired
	private MovimientoDao movimientoDao;
	
	/**
	 * GetMapping para la url "/transferencia" que muestra la pantalla de transferencias.
	 * @return String, archivo que muestra el formulario de transaccionTransferencia
	 */
	@GetMapping("/transferencia")
	public String mostrarTransferencia() {
		return "transaccionTransferencia";
	}
	
	/**
	 * PostMapping para la url "/transferencia".<br>
	 * Capturamos la cuenta que tenemos con la sesión inciada, después hacemos lo mismo con la destino.<br>
	 * Hecho esto agregamos una condición if, ya que el método própio .extraer() devuelve un booleano, si es true montará un objeto movimiento que asignará a la cuenta de la sesión. Acto seguido hará lo mismo pero ingresando el importe en la cuenta destino, en caso contrario siendo false y posible realizar la transferencia porque el importe extraido es superior al capital total de la cuenta, mostraría un mensaje en el HTML.<br>
	 * Finalmente usamos los métodos destinados a insertar los cambios en la base de datos.<br>
	 * 
	 * @return String, si la transacción se realiza de forma correcta nos lleva a la home, sino muestra un mensaje desde la página de transferencia.
	 */
	@PostMapping("/transferencia")
	public String procesarTransferencia(@RequestParam double cantidad , @RequestParam int idDestino , HttpSession session , RedirectAttributes redirectAttributes) {
		
		Cuenta cuenta = (Cuenta)session.getAttribute("cuenta");
		Cuenta cuentaDestino = cuentaDao.buscarCuenta(idDestino);
		
		if(cuenta.extraer(cantidad)) {
			
			Movimiento movimiento = new Movimiento();
			
			movimiento.setCuenta(cuenta);
			movimiento.setFecha(new Date());
			movimiento.setCantidad(cantidad);
			movimiento.setOperacion("Cargo por transferencia");
			
			movimientoDao.insertMovimiento(movimiento);
			cuentaDao.insertCuenta(cuenta);
			
			movimiento = new Movimiento();
			
			cuentaDestino.ingresar(cantidad);
			
			movimiento.setCuenta(cuentaDestino);
			movimiento.setFecha(new Date());
			movimiento.setCantidad(cantidad);
			movimiento.setOperacion("Abono por transferencia");
			
			movimientoDao.insertMovimiento(movimiento);
			cuentaDao.insertCuenta(cuentaDestino);
			
			return"redirect:/";	
		
		}else {
			
			redirectAttributes.addFlashAttribute("mensaje","saldo insuficiente");
			return"redirect:/transferencia";
		
		}
		
	}
	
	/**
	 * GetMapping para la url "/ingresar" que muestra la pantalla de ingreso.
	 * @return String, si la transacción se realiza de forma correcta nos lleva a la home. 
	 */
	@GetMapping("/ingresar")
	public String mostrarIngresar() {
		return"transaccionIngresar";
	}
	
	/**
	 * PostMapping para la url "/ingresar" Capturamos la cuenta de la sesión en una variable cuenta, después aplicamos el método ingresar, creamos un objeto movimiento asignadole la cuenta de la sesión y insertando en la base de datos tanto el cambio en la cuenta como el movimiento.<br>
	 * @return String, nos redirecciona a la home. 
	 */
	@PostMapping("/ingresar")
	public String procesarIngresar(@RequestParam double cantidad , HttpSession session) {
		Cuenta cuenta = (Cuenta)session.getAttribute("cuenta");
		cuenta.ingresar(cantidad);
		
		Movimiento movimiento = new Movimiento();
		movimiento.setCuenta(cuenta);
		movimiento.setFecha(new Date());
		movimiento.setCantidad(cantidad);
		movimiento.setOperacion("Ingresar");
		
		//System.out.println(cuenta);
		//System.out.println(movimiento);
		
		movimientoDao.insertMovimiento(movimiento);
		cuentaDao.insertCuenta(cuenta);
		
		return"redirect:/";		
	}
	
	/**
	 * GetMapping para la url "/extraer" que muestra la pantalla de extraer.
	 * @return String, si la transacción se realiza de forma correcta nos lleva a la home, sino muestra un mensaje desde la página de extraer.
	 */
	@GetMapping("/extraer")
	public String mostrarExtraer() {
		return"transaccionExtraer";
	}
	
	/**
	 * PostMapping para la url "/extraer".<br>
	 * Primeramente capturamos en una variable la cuenta de la sesión.<br>
	 * Mediante un if aplicamos a la cuenta el método extraer, el cual devolverá un boolean si es posuble realizar dicha operación.<br>
	 * Si es posible realizar la operación creará un objeto movimiento asignandole la cuenta de la sesión, y posteriormente usaremos los métodos de inserción del movimeinto y de la cuenta para aplicar los cambios a la base de datos. Si no fuera posible nos devolvería a la página y nos enseñaría un mensaje de error al realizar la operación.<br>
	 * @return String, si la transacción se realiza de forma correcta nos lleva a la home, sino nos mostrará por pantalla un mensaje de error. 
	 */
	@PostMapping("/extraer")
	public String procesarExtraer(@RequestParam double cantidad , HttpSession session , RedirectAttributes redirectAttributes) {
		
		Cuenta cuenta = (Cuenta)session.getAttribute("cuenta");
		
		if(cuenta.extraer(cantidad)) {
			
			Movimiento movimiento = new Movimiento();
			
			movimiento.setCuenta(cuenta);
			movimiento.setFecha(new Date());
			movimiento.setCantidad(cantidad);
			movimiento.setOperacion("Extraer");
			
			movimientoDao.insertMovimiento(movimiento);
			cuentaDao.insertCuenta(cuenta);
			
			return"redirect:/";	
		
		}else {
			
			redirectAttributes.addFlashAttribute("mensaje","saldo insuficiente");
			return"redirect:/extraer";
		
		}
	}
	
	/**
	 * GetMapping para la url "/verMovimientos" capturamos en una variable la cuenta con la sesión iniciada, pasamos por model la cuenta y también los movimientos enlazados a dicha cuenta con el método verTodosMovimientos().
	 * @return String, nos lleva a la página de movimientos de la cuenta con la sesión iniciada.
	 */
	@GetMapping("/verMovimientos")
	public String mostrarMovimientosCuenta(Model model,HttpSession session) {
		
		Cuenta cuenta= (Cuenta)session.getAttribute("cuenta");
		
		model.addAttribute("cuenta",cuenta);
		model.addAttribute("movimientos",movimientoDao.verTodosMovimientos(cuenta));
		return "movimientosCuenta";
	}

}//End TransaccionesController
