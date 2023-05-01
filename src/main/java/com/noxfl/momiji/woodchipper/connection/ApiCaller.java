/**
 * 
 */
package com.noxfl.momiji.woodchipper.connection;

import java.io.IOException;

/**
 * @author Fernando Nathanael
 *
 */
public interface ApiCaller {

	/**
	 *
	 * @return Response
	 * @throws IOException
	 */
	public String send() throws IOException;

}