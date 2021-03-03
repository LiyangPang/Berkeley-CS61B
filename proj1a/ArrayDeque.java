public class ArrayDeque<T>{

	private T[] items;
	private int nextFirst;
	private int nextLast;
	private int size;


	public ArrayDeque(){

		items = (T[])new Object[8];
		nextFirst = 4;
		nextLast = 5;
		size = 0;
	}

	public void addFirst(T item){
		if (size == items.length){
			resize(size*2);
		}

		else{
			items[nextFirst] = item;
			size += 1;
			nextFirst = minusOne(nextFirst);
		}

		
	}

	public void addLast(T item){
		if (size == items.length){
			resize(size*2);
		}

		else{
			items[nextLast] = item;
			size += 1;
			nextLast = plusOne(nextLast);
		}
	}


	public boolean isEmpty(){
		return size == 0;
	}

	public int size(){
		return size;
	}

	public void printDeque(){
		if (size == 0){
			System.out.println("Empty");

		}
		else{
			int i = plusOne(nextFirst);
			while (i != nextLast){
				System.out.print(items[i].toString()+" ");
				i = plusOne(i);
			}
			System.out.println();
		}
	}

	public T removeFirst(){
		if (size==0){
			return null;
		}

		else{
			T item = items[plusOne(nextFirst)];
			items[plusOne(nextFirst)] = null;
			nextFirst = plusOne(nextFirst);
			size -= 1;
			if (items.length >8 &&size == items.length/4){
				resize(items.length/2);
			
			}
			return item;
		}

	}

	public T removeLast(){
		if (size==0){
			return null;
		}

		else{
			T item = items[minusOne(nextLast)];
			items[minusOne(nextLast)] = null;
			nextLast = minusOne(nextLast);
			size -= 1;
			if (items.length >8 &&size == items.length/4){
				resize(items.length/2);
			
			}
		return item;
		}
		
	}

	public T get(int index){
		if (index>size-1||index <0){
			return null;
		}
		else{
			System.out.println(items[(index+nextFirst+1)%items.length]);
			return items[(index+nextFirst+1)%items.length];
		}
	}



	public void resize(int cap){
		T[]a = (T[])new Object[cap];
		if(nextLast == plusOne(nextFirst)){
			System.arraycopy(items,plusOne(nextFirst),a,1,items.length-plusOne(nextFirst));
			System.arraycopy(items,0,a,items.length-plusOne(nextFirst)+1,nextLast);
			nextFirst = 0;
			nextLast = size + 1;
			items = a;
		}
		else{
			if(nextLast>nextFirst){
				System.arraycopy(items,plusOne(nextFirst),a,1,size);
			}
			else{
				System.arraycopy(items,plusOne(nextFirst),a,1,items.length - nextFirst -1);
				System.arraycopy(items,0,a,items.length-nextFirst,nextLast);
			}
			nextFirst = 0;
			nextLast = size + 1;
			items = a;
		}
	}


	public int minusOne(int index){
		if (index!=0){
			return index -1;
		}
		else{
			return items.length -1;
		}
	}

	public int plusOne(int index){
		if (index == items.length -1){
			return 0;
		}
		else{
			return index + 1;
		}
	}


}