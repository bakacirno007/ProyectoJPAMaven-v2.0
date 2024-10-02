package Interfaces;

import java.util.List;

import model.TblProducto;

public interface IProducto {
	void RegistrarProducto(TblProducto producto);
	void ActualizarProducto(TblProducto producto);
	void EliminarProducto(TblProducto producto);
	TblProducto BuscarProducto(TblProducto producto);
	List<TblProducto> ListarProdcuto();


}
