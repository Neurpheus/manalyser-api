/**
 *	This generated bean class Language
 *	matches the schema element 'language'.
 *  The root bean class is Tagset
 *
 *	Generated on Sun Aug 07 18:01:13 CEST 2016
 * @generated
 */

package org.neurpheus.nlp.morphology.tagset.xml;

public class Language {
	private java.util.List _Symbol = new java.util.ArrayList();	// List<String>
	private java.util.List _Name = new java.util.ArrayList();	// List<Name>

	public Language() {
	}

	/**
	 * Required parameters constructor
	 */
	public Language(String[] symbol) {
		if (symbol!= null) {
			for (int i = 0; i < symbol.length; ++i) {
				_Symbol.add(symbol[i]);
			}
		}
	}

	/**
	 * Deep copy
	 */
	public Language(org.neurpheus.nlp.morphology.tagset.xml.Language source) {
		for (java.util.Iterator it = source._Symbol.iterator(); 
			it.hasNext(); ) {
			String element = (String)it.next();
			_Symbol.add(element);
		}
		for (java.util.Iterator it = source._Name.iterator(); 
			it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = (org.neurpheus.nlp.morphology.tagset.xml.Name)it.next();
			_Name.add((element == null) ? null : new org.neurpheus.nlp.morphology.tagset.xml.Name(element));
		}
	}

	// This attribute is an array containing at least one element
	public void setSymbol(String[] value) {
		if (value == null)
			value = new String[0];
		_Symbol.clear();
		for (int i = 0; i < value.length; ++i) {
			_Symbol.add(value[i]);
		}
	}

	public void setSymbol(int index, String value) {
		_Symbol.set(index, value);
	}

	public String[] getSymbol() {
		String[] arr = new String[_Symbol.size()];
		return (String[]) _Symbol.toArray(arr);
	}

	public java.util.List fetchSymbolList() {
		return _Symbol;
	}

	public String getSymbol(int index) {
		return (String)_Symbol.get(index);
	}

	// Return the number of symbol
	public int sizeSymbol() {
		return _Symbol.size();
	}

	public int addSymbol(String value) {
		_Symbol.add(value);
		int positionOfNewItem = _Symbol.size()-1;
		return positionOfNewItem;
	}

	/**
	 * Search from the end looking for @param value, and then remove it.
	 */
	public int removeSymbol(String value) {
		int pos = _Symbol.indexOf(value);
		if (pos >= 0) {
			_Symbol.remove(pos);
		}
		return pos;
	}

	// This attribute is an array, possibly empty
	public void setName(org.neurpheus.nlp.morphology.tagset.xml.Name[] value) {
		if (value == null)
			value = new Name[0];
		_Name.clear();
		for (int i = 0; i < value.length; ++i) {
			_Name.add(value[i]);
		}
	}

	public void setName(int index, org.neurpheus.nlp.morphology.tagset.xml.Name value) {
		_Name.set(index, value);
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Name[] getName() {
		Name[] arr = new Name[_Name.size()];
		return (Name[]) _Name.toArray(arr);
	}

	public java.util.List fetchNameList() {
		return _Name;
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Name getName(int index) {
		return (Name)_Name.get(index);
	}

	// Return the number of name
	public int sizeName() {
		return _Name.size();
	}

	public int addName(org.neurpheus.nlp.morphology.tagset.xml.Name value) {
		_Name.add(value);
		int positionOfNewItem = _Name.size()-1;
		return positionOfNewItem;
	}

	/**
	 * Search from the end looking for @param value, and then remove it.
	 */
	public int removeName(org.neurpheus.nlp.morphology.tagset.xml.Name value) {
		int pos = _Name.indexOf(value);
		if (pos >= 0) {
			_Name.remove(pos);
		}
		return pos;
	}

	public void writeNode(java.io.Writer out, String nodeName, String indent) throws java.io.IOException {
		out.write(indent);
		out.write("<");
		out.write(nodeName);
		out.write(">\n");
		String nextIndent = indent + "	";
		for (java.util.Iterator it = _Symbol.iterator(); it.hasNext(); ) {
			String element = (String)it.next();
			if (element != null) {
				out.write(nextIndent);
				out.write("<symbol");	// NOI18N
				out.write(">");	// NOI18N
				org.neurpheus.nlp.morphology.tagset.xml.Tagset.writeXML(out, element, false);
				out.write("</symbol>\n");	// NOI18N
			}
		}
		for (java.util.Iterator it = _Name.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = (org.neurpheus.nlp.morphology.tagset.xml.Name)it.next();
			if (element != null) {
				element.writeNode(out, "name", nextIndent);
			}
		}
		out.write(indent);
		out.write("</"+nodeName+">\n");
	}

	public void readNode(org.w3c.dom.Node node) {
		org.w3c.dom.NodeList children = node.getChildNodes();
		for (int i = 0, size = children.getLength(); i < size; ++i) {
			org.w3c.dom.Node childNode = children.item(i);
			String childNodeName = (childNode.getLocalName() == null ? childNode.getNodeName().intern() : childNode.getLocalName().intern());
			String childNodeValue = "";
			if (childNode.getFirstChild() != null) {
				childNodeValue = childNode.getFirstChild().getNodeValue();
			}
			if (childNodeName == "symbol") {
				String aSymbol;
				aSymbol = childNodeValue;
				_Symbol.add(aSymbol);
			}
			else if (childNodeName == "name") {
				Name aName = new org.neurpheus.nlp.morphology.tagset.xml.Name();
				aName.readNode(childNode);
				_Name.add(aName);
			}
			else {
				// Found extra unrecognized childNode
			}
		}
	}

	public void validate() throws org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException {
		boolean restrictionFailure = false;
		// Validating property symbol
		if (sizeSymbol() == 0) {
			throw new org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException("sizeSymbol() == 0", org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException.FailureType.NULL_VALUE, "symbol", this);	// NOI18N
		}
		// Validating property name
		for (int _index = 0; _index < sizeName(); ++_index) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = getName(_index);
			if (element != null) {
				element.validate();
			}
		}
	}

	public void changePropertyByName(String name, Object value) {
		if (name == null) return;
		name = name.intern();
		if (name == "symbol")
			addSymbol((String)value);
		else if (name == "symbol[]")
			setSymbol((String[]) value);
		else if (name == "name")
			addName((Name)value);
		else if (name == "name[]")
			setName((Name[]) value);
		else
			throw new IllegalArgumentException(name+" is not a valid property name for Language");
	}

	public Object fetchPropertyByName(String name) {
		if (name == "symbol[]")
			return getSymbol();
		if (name == "name[]")
			return getName();
		throw new IllegalArgumentException(name+" is not a valid property name for Language");
	}

	public String nameSelf() {
		return "language";
	}

	public String nameChild(Object childObj) {
		if (childObj instanceof String) {
			String child = (String) childObj;
			int index = 0;
			for (java.util.Iterator it = _Symbol.iterator(); it.hasNext(); 
				) {
				String element = (String)it.next();
				if (child == element) {
					return "symbol."+index;
				}
				++index;
			}
		}
		if (childObj instanceof Name) {
			Name child = (Name) childObj;
			int index = 0;
			for (java.util.Iterator it = _Name.iterator(); it.hasNext(); ) {
				org.neurpheus.nlp.morphology.tagset.xml.Name element = (org.neurpheus.nlp.morphology.tagset.xml.Name)it.next();
				if (child == element) {
					return "name."+index;
				}
				++index;
			}
		}
		return null;
	}

	/**
	 * Return an array of all of the properties that are beans and are set.
	 */
	public java.lang.Object[] childBeans(boolean recursive) {
		java.util.List children = new java.util.LinkedList();
		childBeans(recursive, children);
		java.lang.Object[] result = new java.lang.Object[children.size()];
		return (java.lang.Object[]) children.toArray(result);
	}

	/**
	 * Put all child beans into the beans list.
	 */
	public void childBeans(boolean recursive, java.util.List beans) {
		for (java.util.Iterator it = _Name.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = (org.neurpheus.nlp.morphology.tagset.xml.Name)it.next();
			if (element != null) {
				if (recursive) {
					element.childBeans(true, beans);
				}
				beans.add(element);
			}
		}
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof org.neurpheus.nlp.morphology.tagset.xml.Language))
			return false;
		org.neurpheus.nlp.morphology.tagset.xml.Language inst = (org.neurpheus.nlp.morphology.tagset.xml.Language) o;
		if (sizeSymbol() != inst.sizeSymbol())
			return false;
		// Compare every element.
		for (java.util.Iterator it = _Symbol.iterator(), it2 = inst._Symbol.iterator(); 
			it.hasNext() && it2.hasNext(); ) {
			String element = (String)it.next();
			String element2 = (String)it2.next();
			if (!(element == null ? element2 == null : element.equals(element2))) {
				return false;
			}
		}
		if (sizeName() != inst.sizeName())
			return false;
		// Compare every element.
		for (java.util.Iterator it = _Name.iterator(), it2 = inst._Name.iterator(); 
			it.hasNext() && it2.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = (org.neurpheus.nlp.morphology.tagset.xml.Name)it.next();
			org.neurpheus.nlp.morphology.tagset.xml.Name element2 = (org.neurpheus.nlp.morphology.tagset.xml.Name)it2.next();
			if (!(element == null ? element2 == null : element.equals(element2))) {
				return false;
			}
		}
		return true;
	}

	public int hashCode() {
		int result = 17;
		result = 37*result + (_Symbol == null ? 0 : _Symbol.hashCode());
		result = 37*result + (_Name == null ? 0 : _Name.hashCode());
		return result;
	}

}


/*
		The following schema file has been used for generation:

<?xml version='1.0' encoding='UTF-8'?>

<!--- Root element of the tagset definition. -->
<!ELEMENT tagset (language*, category*)>
<!ATTLIST tagset xmlns CDATA #IMPLIED>

<!--- Describes one of the language used in documents. Language can have many symbols and names. -->
<!ELEMENT language (symbol+, name*)>

<!--- A symbol of a language, a tag, a category and so on. -->
<!ELEMENT symbol (#PCDATA)>

<!--- A value of name, description and so on -->
<!ELEMENT value (#PCDATA)>

<!--- A value of name, description and so on -->
<!ELEMENT lang (#PCDATA)>

<!--- Name of a tag or a grammatical category written in the specified language. -->
<!ELEMENT name (lang, value)>

<!--- Describes a grammatical category. The category can have symbol, many names, descriptions, and tags. -->
<!ELEMENT category (symbol, name*, description*, tag*)>

<!--- Describes a grammatical category or a tag in the specified language. -->
<!ELEMENT description (lang, value)>

<!--- A tag representing a grammatical property. Each tag can be specified using many symbols, examples, descriptions and names. -->
<!ELEMENT tag (symbol, name*, description*, example*)>

<!--- An example word form written in a given language. -->
<!ELEMENT example (lang, value)>

*/
