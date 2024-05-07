
public class VetorDinamico {

	private Object buffer[]; // onde se vão armazenar os elementos
	private int nElems; // nº de elementos úteis no vector
	private int capMaxima; // nº de elementos máximo no vector
	private int incremento; // nº de elementos a adicionar quando estiver cheio


	// construtor para inicializar o vector a uma dada capacidade inicial
	// e um incremento com valores por defeito
	public VetorDinamico() {
		this( 1, 1 ); // capacidade inicial 1 e incremento 1
	}
	// construtor para inicializar com uma dada capacidade inicial
	// incremento é metade deste valor
	public VetorDinamico( int capInicial ) {this( capInicial, capInicial/2 + 1); }
	// construtor que permite definir uma capacidade inicial e um incremento
	public VetorDinamico( int capInicial, int incre ) { 

		if( capInicial <= 0 )
			capInicial = 1;
		if( incre <= 0 )
			incre = capInicial / 2 + 1;
		nElems = 0;
		buffer = new Object[ capInicial ];
		capMaxima = capInicial;
		incremento = incre;
	}

	public boolean estaCheio( ) { // indica se vector está cheio
		return nElems == capMaxima;
	}


	public void adicionar( Object x ) {
		if( estaCheio() )
			aumentar( );
		buffer[ nElems ] = x;
		nElems++;
	}

	private void aumentar( ) {
		Object novoBuffer[] = new Object[ capMaxima + incremento ];
		for( int i = 0; i < nElems; i++ )
			novoBuffer[i] = buffer[i];
		buffer = novoBuffer;
		capMaxima += incremento;
	}

	public void retirar( ) {
		buffer[ nElems ] = buffer[ nElems-1 ];
		nElems--;
	}

	public Object retirar( int idx ) {
		Object antigo = buffer[ idx ];
		buffer[ idx ] = buffer[ nElems-1 ];
		nElems--;
		return antigo;
	}

	public void inserir(Object x, int idx ) {
		if( idx > nElems )
			return;
		if( estaCheio() )
			aumentar( );
		for( int i = nElems; i > idx; i-- )
			buffer[ i ] = buffer[ i - 1 ];
		buffer[ idx ] = x;
		nElems++;
	}

	void diminuir( ) {
		if( nElems < capMaxima - incremento * 1.5 ) {
			Object [] novoBuffer = new Object[ capMaxima - incremento ];
			for( int i=0; i < nElems; i++ )
				novoBuffer[i] = buffer[ i ];
			buffer =  novoBuffer;
			capMaxima -= incremento;
		}
	}

	public int procura( Object e, int posIni ){
		for( int i = posIni; i < nElems; i++ )
			if( buffer[ i ].equals( e ) )
				return i;
		return -1;
	}
	public int procura( Object e ) {
		return procura( e, 0 );
	}

	public int procuraFim( Object e ) {
		return procuraFim( e, nElems-1 );
	}
	public int procuraFim( Object e, int posFim ) {
		for( int i = posFim; i >= 0; i-- )
			if( buffer[ i ].equals( e ) )
				return i;
		return -1;
	}

	public boolean estaPresente( Object e ){
		return procura( e ) != -1;
	}

	public int numRepeticoes( Object e ){
		int nVezes = 0;
		int proxIdx = procura( e );
		while( proxIdx != -1 ) {
			nVezes++;
			proxIdx = procura( e, proxIdx + 1 );
		}
		return nVezes;
	}

	public void retirar( Object e ) {
		int idx = procura( e );
		if( idx != -1 )
			retirar ( idx );
	}
	public void retirarTodas( Object e ) {
		int idx = procura( e );
		while( idx != -1 ) {
			retirar( idx );
			idx = procura( e, idx );
		}
	}

	public void limpar( ) {
		nElems = 0;
	}


	public Object get( int idx ) {
		if( !indiceValido(idx) )
			throw new ArrayIndexOutOfBoundsException();
		return buffer[ idx ];
	}
	private boolean indiceValido(int idx) {
		// TODO Auto-generated method stub
		return idx >=0 && idx <= buffer.length;
	}
	public void set( int idx, Object e ){
		if( !indiceValido(idx) )
			throw new ArrayIndexOutOfBoundsException();
		buffer[ idx ] = e;
	}

	public void setIncremento( int novoInc ) {
		incremento = novoInc <= 0? incremento: novoInc;
	}

	public void assegurarCapacidade( int capMinima ) {
		while( capMaxima < capMinima )
			aumentar();
	}
	
	public Object[] getBuffer() {
		return buffer;
	}
	public void setBuffer(Object[] buffer) {
		this.buffer = buffer;
	}
	public int getnElems() {
		return nElems;
	}
	public void setnElems(int nElems) {
		this.nElems = nElems;
	}
	public int getCapMaxima() {
		return capMaxima;
	}
	public void setCapMaxima(int capMaxima) {
		this.capMaxima = capMaxima;
	}
	public int getIncremento() {
		return incremento;
	}
}

