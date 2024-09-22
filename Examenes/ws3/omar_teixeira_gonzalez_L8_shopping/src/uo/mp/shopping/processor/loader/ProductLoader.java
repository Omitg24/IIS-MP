package uo.mp.shopping.processor.loader;

import java.io.FileNotFoundException;

import uo.mp.collections.List;
import uo.mp.file.TxtFileUtil;
import uo.mp.shopping.model.Product;

public class ProductLoader {
	private String fileName;

	public ProductLoader(String fileName) {		
		this.fileName = fileName;
	}

	public List<Product> load() throws FileNotFoundException  {
		List<String> lines = new TxtFileUtil().readLines( fileName );
		return new ProductParser().parse( lines );	
	}

}
