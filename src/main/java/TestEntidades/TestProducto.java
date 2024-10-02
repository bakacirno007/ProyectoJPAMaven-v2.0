package TestEntidades;

import java.util.Date;

import DaoImp.TblProductoImp;
import Interfaces.IProducto;
import model.TblProducto;

public abstract class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TblProducto tblpro = new TblProducto();
		TblProductoImp proimp = new TblProductoImp();
		
		
		
		tblpro.setNomprod("asd");
		tblpro.setPrecio(3.99);
		tblpro.setCantidad(4);
		tblpro.setTotal(tblpro.getPrecio()*tblpro.getCantidad());
		tblpro.setCodbarras("3456719");
		tblpro.setNorlote("lote4344");
		Date fecha = new Date(); 
		Date fechasql = new Date(fecha.getTime());
		proimp.RegistrarProducto(tblpro);
		System.out.println("Datos registrados...");

	}

}
