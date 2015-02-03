/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.civmmo.model.autogenerate;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Mattysek
 */
public class Generator {
    public static void Generate() throws IOException
    {
        PodamFactory factory = new PodamFactoryImpl(); //This will use the default Random Data Provider Strategy
        ActionImpl pojo = factory.manufacturePojo(ActionImpl.class);
                
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(pojo));
    }
}
