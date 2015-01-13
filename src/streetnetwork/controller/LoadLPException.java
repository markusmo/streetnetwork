/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streetnetwork.controller;

/**
 *
 * @author mohi
 */
public class LoadLPException extends Exception
{
    private String message;
    private String localizedMessage;
    
    public LoadLPException(Exception ex)
    {
        super.setStackTrace(ex.getStackTrace());
        this.message = ex.getMessage();
        this.localizedMessage = ex.getLocalizedMessage();
    }

    @Override
    public String getLocalizedMessage()
    {
        return this.localizedMessage;
    }

    @Override
    public String getMessage()
    {
        return this.message;
    }
}
