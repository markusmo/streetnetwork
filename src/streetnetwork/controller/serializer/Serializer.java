package streetnetwork.controller.serializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import streetnetwork.viewmodels.VIntersection;

/**
 *
 * @author mohi
 *
 * Using JAXB to marshall and unmarshall vintersection objects
 * 
 * Examples at 
 * http://www.mkyong.com/java/jaxb-hello-world-example/
 * http://stackoverflow.com/questions/13159089/marshalling-nested-classes-with-jaxb
 * http://howtodoinjava.com/2013/07/30/jaxb-exmaple-marshalling-and-unmarshalling-list-or-set-of-objects/
 */
public class Serializer
{
    private static Serializer INSTANCE = null;
    
    private Serializer(){};
    
    public static Serializer getInstance()
    {
        if(INSTANCE == null)
        {
            INSTANCE = new Serializer();
        }
        return INSTANCE;
    }

    public void writeToFile(String filepath, VIntersection[][] intersections, int rows, int columns) throws FileNotFoundException, JAXBException
    {
        JAXBContext jaxbcontext = JAXBContext.newInstance(VIntersections.class);
        Marshaller marshaller = jaxbcontext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        VIntersections vintersections = createListOfVIntersections(intersections, rows, columns);
        
        marshaller.marshal(vintersections, new File(filepath));
    }
    
    public VIntersection[][] readFromFile(String filepath) throws JAXBException
    {
        JAXBContext jaxbcontext = JAXBContext.newInstance(VIntersections.class);
        Unmarshaller unmarshaller = jaxbcontext.createUnmarshaller();
        
        VIntersections vins = (VIntersections) unmarshaller.unmarshal(new File(filepath));
        
        return createVIntersections(vins);
    }

    private VIntersections createListOfVIntersections(VIntersection[][] intersections, int rows, int columns)
    {
        VIntersections vins = new VIntersections();
        
        List<VIntersection> vintersections = new ArrayList<VIntersection>();
        
        for (int row = 0; row < rows; row++)
        {
            for (int column = 0; column < columns; column++)
            {
                vintersections.add(intersections[row][column]);
            }
        }
        vins.setIntersections(vintersections);
        return vins;
    }
    
    private VIntersection[][] createVIntersections(VIntersections vintersections)
    {
        List<VIntersection> vins = vintersections.getIntersections();
        int maxX = 0;
        int maxY = 0;
        for (VIntersection vin : vins)
        {
            if(maxX < vin.getX())
            {
                maxX = vin.getX();
            }
            if (maxY < vin.getY())
            {
                maxY = vin.getY();
            }
        }
        
        VIntersection[][] intersections = new VIntersection[maxX+1][maxY+1];
        for (VIntersection vin : vins)
        {
            intersections[vin.getX()][vin.getY()] = vin;
        }
        
        return intersections;
    }
}
