package com.sanaTF.service;

import java.util.List;
import com.sanaTF.model.Solicitudes;

public interface SolicitudesService {
	public void add(Solicitudes solicitudes);
	public void edit(Solicitudes solicitudes);
	public void delete(int idSolicitudes);
	public Solicitudes getSolicitudes(int idSolicitudes);
	public List getAllSolicitudes();
}
