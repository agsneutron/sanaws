

	package com.sanaTF.dao.impl;

	import java.util.List;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

	import com.sanaTF.dao.UsoRecursosDao;
	import com.sanaTF.model.UsoRecursos;


	@Repository
	public class UsoRecursosDaoImpl implements UsoRecursosDao {
		@Autowired
		private SessionFactory session;

		@Override
		public void add(UsoRecursos usorecursos) {
			session.getCurrentSession().save(usorecursos);

		}

		@Override
		public void edit(UsoRecursos usorecursos) {
			session.getCurrentSession().update(usorecursos);

		}

		@Override
		public void delete(int idUsoRecursos) {
			session.getCurrentSession().delete(getUsoRecursos(idUsoRecursos));

		}

		@Override
		public UsoRecursos getUsoRecursos(int idUsoRecursos) {
			return (UsoRecursos)session.getCurrentSession().createQuery("from UsoRecursos f where f.idUsoRecursos=:idUsoRecursos")
					.setParameter("idUsoRecursos",idUsoRecursos)
					.uniqueResult();
					
		}


		@Override
		public List getAllUsoRecursos() {
			return session.getCurrentSession().createQuery("from UsoRecursos").list();
		}

	}


