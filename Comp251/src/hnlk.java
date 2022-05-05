//int s = 0;
//        ArrayList<String> array = new ArrayList<String>();
//        ArrayList<String> change = new ArrayList<String>();
//        ArrayList<String> changs = new ArrayList<String>();
//
//        Map<String, Integer> hashMap = new HashMap<>();
//        Map<String, String[]> people = new HashMap<>();
//        Map<String, Integer> frequency = new HashMap<>();
//        Map<String, Integer> fin = new HashMap<>();
//
//
//        for (int i = 0; i < posts.length; i++) {
//        String[] words = posts[i].split(" ");
//
//        String[] newArr = Arrays.copyOfRange(words, 1, words.length);
//        String name = words[0];
//        if (people.get(name) == null) {
//        people.put(name, newArr);
//        } else {
//        String[] both = new String[people.get(name).length + newArr.length];
//        System.arraycopy(people.get(name), 0, both, 0, people.get(name).length);
//        System.arraycopy(newArr, 0, both, people.get(name).length, newArr.length);
//        people.put(name, both);
//        }
//        }
//        for (Map.Entry<String, String[]> set : people.entrySet()) {
//        Map<String, Integer> hashMap1 = new HashMap<>();
//        for (String word : set.getValue()) {
//
//        Integer integer = hashMap1.get(word);
//        Integer freq = frequency.get(word);
//
//
//        if (integer == null) {
//        hashMap1.put(word, 1);
//        } if(freq == null){
//        frequency.put(word, 1);
//        }if(freq != null){
//        frequency.put(word, frequency.get(word) + 1);
//        }
//        }
//
//        for (Map.Entry<String, Integer> entry : hashMap1.entrySet()) {
//        entry.getKey();
//        entry.getValue();
//        hashMap.get(entry.getKey());
//        // using put method to copy one Map to Other
//        if (hashMap.get(entry.getKey()) == null) {
//        s = 0;
//        } else {
//        s = hashMap.get(entry.getKey());
//        }
//        hashMap.put(entry.getKey(),
//        (int) entry.getValue() + s);
//        }
//
//        }
//        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
//        if (entry.getValue() == people.size()) {
//        array.add(entry.getKey());
//        }
//        }
//        Map<Integer, String> map=new HashMap<Integer, String>();
//
//        for(int i = 0; i< array.size();i++){
//        fin.put(array.get(i), frequency.get(array.get(i)));
//        }
////		TreeMap<String, Integer> tm=new  TreeMap<String, Integer> (fin);
////		Iterator itr=tm.keySet().iterator();
////
////		while(itr.hasNext())
////		{
////			change.add((String) itr.next());
////		}
//        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(fin.entrySet());
////sorting the list elements
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
//        {
//public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
//        return o1.getValue().compareTo(o2.getValue());
//
//        }
//        });
//        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
//        for (Map.Entry<String, Integer> entry : list)
//        {
//        sortedMap.put(entry.getKey(), entry.getValue());
//        }
//
////		Object[] arrayS = sortedMap.keySet().toArray();
////
////		for(int i=0;i<arrayS.length;i++)
////		{
////			if(sortedMap.containsValue(sortedMap.get(arrayS[i]))) {
////				changs.add((String)arrayS[i]);
////		}
////		}
//        //Collections<Integer> valuesList = sortedMap.values();
//        Set<Integer> valuesSet = new HashSet<Integer>(sortedMap.values());
//
//        if(sortedMap.size() != valuesSet.size()){
//        Map<String, Integer> sortedMapf = new TreeMap<>(sortedMap);
//        //sortedMapf.entrySet().forEach(System.out::println);
//
//        for (Map.Entry<String, Integer> entry : sortedMapf.entrySet())
//        {
//        //System.out.println(entry.getKey() +"\t"+entry.getValue());
//        change.add(entry.getKey());
//        }
//
//        }
//        else{
//        for (Map.Entry<String, Integer> entry : sortedMap.entrySet())
//        {
//        //System.out.println(entry.getKey() +"\t"+entry.getValue());
//        change.add(entry.getKey());
//        }
//        Collections.reverse(change);
//        }
//
//
//
////		for(Map.Entry<String, Integer> entry2: tm.entrySet()) {
//////				if(entry2.getValue() == value) {
////					change.add(entry2.getKey());
//
////				}
//        //	}
//
////		for (Map.Entry<String, Integer> entry1 : fin.entrySet()) {
////			System.out.println("key:" + " " + entry1.getKey() + " ; " +  "value:" + " " +  entry1.getValue());
////
////		}
//        return change;
//        }
//        }
