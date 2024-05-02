package com.example;

public class TElementoAB<T> implements IElementoAB<T> {

    private Comparable etiqueta;
    private TElementoAB<T> hijoIzq;
    private TElementoAB<T> hijoDer;
    private T datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    @SuppressWarnings("unchecked")
    public TElementoAB(Comparable unaEtiqueta, T unosDatos) {
        etiqueta = unaEtiqueta;
        datos = unosDatos;
    }

    public TElementoAB<T> getHijoIzq() {
        return hijoIzq;
    }

    public TElementoAB<T> getHijoDer() {
        return hijoDer;
    }

    /**
     * @param unElemento
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean insertar(TElementoAB<T> unElemento) {
        if (unElemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().insertar(unElemento);
            } else {
                hijoIzq = unElemento;
                return true;
            }
        } else if (unElemento.getEtiqueta().compareTo(etiqueta) > 0) {
            if (hijoDer != null) {
                return getHijoDer().insertar(unElemento);
            } else {
                hijoDer = unElemento;
                return true;
            }
        } else {
            // ya existe un elemento con la misma etiqueta.-
            return false;
        }
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TElementoAB<T> buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return getHijoIzq().buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return getHijoDer().buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        String result = "";

        if (this.hijoIzq != null) {
            result += hijoIzq.inOrden() + TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS;
        }
        result += this.etiqueta;

        if (this.hijoDer != null) {
            result += TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS + hijoDer.inOrden();
        }
        return result;
    }

    public String postOrden() {
        // TODO Auto-generated method stub
        String result = "";

        if (this.hijoIzq != null) {
            result += hijoIzq.postOrden() + TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS;
        }
        if (this.hijoDer != null) {
            result += hijoDer.postOrden() + TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS;
        }
        return result += this.etiqueta;
    }

    public String preOrden() {

        String result = this.etiqueta.toString();

        if (this.hijoIzq != null) {
            result += TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS + hijoIzq.preOrden();
        }
        if (this.hijoDer != null) {
            result += TArbolBB.SEPARADOR_ELEMENTOS_IMPRESOS + hijoDer.preOrden();
        }

        return result;
    }

    @Override
    public void inOrden(Lista<T> unaLista) {

        if (this.hijoIzq != null) {
            this.hijoIzq.inOrden(unaLista);
        }

        Nodo nodo = new Nodo(this.etiqueta, this.datos);
        unaLista.insertar(nodo);

        if (this.hijoDer != null) {
            this.hijoDer.inOrden(unaLista);
        }

    }

    @Override
    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    @Override
    public T getDatos() {
        return datos;
    }

    @Override
    public void setHijoIzq(TElementoAB<T> elemento) {
        this.hijoIzq = elemento;

    }

    @Override
    public void setHijoDer(TElementoAB<T> elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public int obtenerAltura() {

        int alturaIzq = -1;
        int alturaDer = -1;

        if (this.hijoIzq != null) {
            alturaIzq = this.hijoIzq.obtenerAltura();
        }

        if (this.hijoDer != null) {
            alturaDer = this.hijoDer.obtenerAltura();
        }

        return Math.max(alturaIzq, alturaDer) + 1;

    }

    @Override
    public int obtenerTamanio() {

        int tamanio = 0;

        if (hijoIzq != null) {
            tamanio += hijoIzq.obtenerTamanio();
        }

        if (hijoDer != null) {
            tamanio += hijoDer.obtenerTamanio();
        }

        return tamanio + 1;
    }

    @Override
    public int obtenerNivel(Comparable unaEtiqueta) {

        int nivel = -1;

        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (hijoIzq != null) {
                nivel = hijoIzq.obtenerNivel(unaEtiqueta);
            }

        } else if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (hijoDer != null) {
                nivel = hijoDer.obtenerNivel(unaEtiqueta);
            }
        } else {
            return 0;
        }

        if (nivel == -1) {
            return -1;
        }

        return nivel + 1;
    }

    @Override
    public int obtenerCantidadHojas() {
        int x = 0;
        int y = 0;

        if (this.hijoIzq != null) {
            x = this.hijoIzq.obtenerCantidadHojas();
        }

        if (this.hijoDer != null) {
            y = this.hijoDer.obtenerCantidadHojas();
        }

        if (this.hijoIzq == null && this.hijoDer == null) {
            return 1;
        }

        return x + y;
    }

    @Override
    public TElementoAB eliminar(Comparable unaEtiqueta) {
        if (unaEtiqueta.compareTo(this.etiqueta) < 0) {
            if (this.hijoIzq != null) {
                this.hijoIzq = this.hijoIzq.eliminar(unaEtiqueta);
            }
            return this;
        }

        if (unaEtiqueta.compareTo(this.etiqueta) > 0) {
            if (this.hijoDer != null) {
                this.hijoDer = this.hijoDer.eliminar(unaEtiqueta);
            }
            return this;
        }
        return quitaElNodo();

    }

    private TElementoAB quitaElNodo() {
        if (this.hijoIzq == null) {
            return this.hijoDer;
        }

        if (this.hijoDer == null) {
            return this.hijoIzq;
        }

        TElementoAB<T> elHijo = this.hijoIzq;
        TElementoAB<T> elPadre = this;

        while (elHijo.hijoDer != null) {
            elPadre = elHijo;
            elHijo = elHijo.hijoDer;
        }

        if (elPadre != this) {
            elPadre.hijoDer = elHijo.hijoIzq;
            elHijo.hijoIzq = this.hijoIzq;
        }

        elHijo.hijoDer = this.hijoDer;
        return elHijo;

    }

}
