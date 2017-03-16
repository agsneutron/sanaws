package com.sanaws.service;


import java.util.List;

import com.sanaws.model.TipoCredito;

public interface TipoCreditoService {
	public void add(TipoCredito tipocredito);
	public void edit(TipoCredito tipocredito);
	public void delete(int idTipoCredito);
	public TipoCredito getTipoCredito(int idTipoCredito);
	public List getAllTipoCredito();
}
