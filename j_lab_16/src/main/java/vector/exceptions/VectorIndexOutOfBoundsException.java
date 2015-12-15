/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector.exceptions;

/**
 * @author netcracker
 */
public class VectorIndexOutOfBoundsException extends ArrayIndexOutOfBoundsException{
    public VectorIndexOutOfBoundsException() {
        super();
    }

    public VectorIndexOutOfBoundsException(String name) {
        super(name);
    }
}
