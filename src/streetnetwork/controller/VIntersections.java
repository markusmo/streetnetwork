/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streetnetwork.controller;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import streetnetwork.viewmodels.VIntersection;

/**
 *
 * @author mohi
 */
@XmlRootElement (name = "intersections")
@XmlAccessorType (XmlAccessType.FIELD)
public class VIntersections
{
    @XmlElement(name = "intersection")
    private List<VIntersection> intersections = null;

    public VIntersections(){}
    
    public List<VIntersection> getIntersections()
    {
        return intersections;
    }

    public void setIntersections(List<VIntersection> intersections)
    {
        this.intersections = intersections;
    }
    
    
}
