
public class ListaLigada {

	private int nElementos;
	private No cabeca;
	private class No {
		No prox;
		Carta item;

		No( Carta e ) {
			item = e; // o item passa a ser o elemento
			prox = null; // o nó é inicializado com prox a null (não há próximo)
		}
	}

	public ListaLigada( ){
		cabeca = null;
		setnElementos(0);
	}

	public void inserirCabeca( Carta e ){
		No novoNo = new No( e );
		novoNo.prox = cabeca;
		cabeca = novoNo;
		setnElementos(getnElementos() + 1);
	}

	public void inserirCauda( Carta e ){
		No novoNo = new No( e );
		if( cabeca == null ) {
			cabeca = novoNo;
			setnElementos(getnElementos() + 1);
			return;
		}
		No ultimo = cabeca;
		while( ultimo.prox != null )
			ultimo = ultimo.prox;
		ultimo.prox = novoNo;
		setnElementos(getnElementos() + 1);
	}

	public void inserirOrdem( Carta e ) {
		No novoNo = new No( e );
		No actual = cabeca;
		No anterior = null;
		// procurar o local onde inserir
		while( actual != null && (actual.item).compareTo( e ) < 0 ) {
			anterior = actual;
			actual = actual.prox;
		}
		novoNo.prox = actual;
		if( anterior == null )
			cabeca = novoNo;
		else
			anterior.prox = novoNo;
		setnElementos(getnElementos() + 1);
	}


	public boolean eIndiceValido(int i) {
		return i >= 0 && i<= nElementos;

	}
	public boolean estaPresente( Carta e ) {
		return procura( e ) != -1;
		}

	public void inserir( Carta e, int idx ) {
		if( !eIndiceValido( idx ) )
			throw new ArrayIndexOutOfBoundsException( idx );
		No novoNo = new No( e );
		int posActual = 0;
		No actual = cabeca;
		No anterior = null;
		while( actual != null && posActual < idx ) {
			anterior = actual;
			actual = actual.prox;
			posActual++;
		}
		novoNo.prox = actual;
		if( anterior == null )
			cabeca = novoNo;
		else
			anterior.prox = novoNo;
		setnElementos(getnElementos() + 1);
	}

	public int procurarOrdenada( Carta e ){
		No actual = cabeca;
		int pos = 0;
		while( actual != null && !actual.item.equals( e ) ) {
			actual = actual.prox;
			pos++;
		}
		return actual == null ? -1: pos;
	}

	public int procura( Carta e ) {
		No actual = cabeca;
		int pos = 0;
		while( actual != null && actual.item.compareTo( e ) < 0 ) {
			actual = actual.prox;
			pos++;
		}
		if( actual != null && actual.item.equals( e ))
			return pos;
		return -1;
	}


	public void retirar( int idx ){
		if( !eIndiceValido( idx ) )
			throw new ArrayIndexOutOfBoundsException( idx );
		No actual = cabeca;
		No anterior = null;
		int pos = 0;
		while( actual != null && pos < idx ) {
			anterior = actual;
			actual = actual.prox;
			pos++;
		}
		if( anterior != null )
			anterior.prox = actual.prox;
		else
			cabeca = actual.prox;
		setnElementos(getnElementos() - 1);
	}

	public Carta get( int idx ) {
		if( !eIndiceValido( idx ) )
			throw new ArrayIndexOutOfBoundsException( "O indice"+idx+ "é Invalido " );
		No actual = cabeca;
		int pos = 0;
		while( pos < idx ) {
			pos++;
			actual = actual.prox;
		}
		return actual.item;
	}

	public int getnElementos() {
		return nElementos;
	}

	public void setnElementos(int nElementos) {
		this.nElementos = nElementos;
	}



}
