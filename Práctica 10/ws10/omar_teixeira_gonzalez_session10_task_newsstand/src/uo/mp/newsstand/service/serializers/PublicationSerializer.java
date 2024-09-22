package uo.mp.newsstand.service.serializers;

import java.util.LinkedList;
import java.util.List;

import uo.mp.newsstand.domain.Publication;

/**
 * Titulo: Clase PublicationSerializer
 * 
 * @author Omitg
 * @version 07-04-2021
 */
public class PublicationSerializer {
	
	/**
	 * Nétodo que devuelve una lista de strings tras serializar todas las 
	 * publicaciones
	 * 
	 * @param publications, lista de publicaciones 
	 * @return res, lista con la serializacion de las publicaciones
	 */
	public List<String> serialize(List<Publication> publications) {
		List<String> res = new LinkedList<>();
		for(Publication p: publications) {
			res.add( p.serialize() );
		}
		return res;
	}

}
