/**
 *	This generated bean class Category
 *	matches the schema element 'category'.
 *  The root bean class is Tagset
 *
 *	Generated on Sun Aug 07 18:01:13 CEST 2016
 * @generated
 */

package org.neurpheus.nlp.morphology.tagset.xml;

public class Category {
	private String _Symbol;
	private java.util.List _Name = new java.util.ArrayList();	// List<Name>
	private java.util.List _Description = new java.util.ArrayList();	// List<Description>
	private java.util.List _Tag = new java.util.ArrayList();	// List<Tag>

	public Category() {
		_Symbol = "";
	}

	/**
	 * Required parameters constructor
	 */
	public Category(String symbol) {
		_Symbol = symbol;
	}

	/**
	 * Deep copy
	 */
	public Category(org.neurpheus.nlp.morphology.tagset.xml.Category source) {
		_Symbol = source._Symbol;
		for (java.util.Iterator it = source._Name.iterator(); 
			it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = (org.neurpheus.nlp.morphology.tagset.xml.Name)it.next();
			_Name.add((element == null) ? null : new org.neurpheus.nlp.morphology.tagset.xml.Name(element));
		}
		for (java.util.Iterator it = source._Description.iterator(); 
			it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Description element = (org.neurpheus.nlp.morphology.tagset.xml.Description)it.next();
			_Description.add((element == null) ? null : new org.neurpheus.nlp.morphology.tagset.xml.Description(element));
		}
		for (java.util.Iterator it = source._Tag.iterator(); it.hasNext(); 
			) {
			org.neurpheus.nlp.morphology.tagset.xml.Tag element = (org.neurpheus.nlp.morphology.tagset.xml.Tag)it.next();
			_Tag.add((element == null) ? null : new org.neurpheus.nlp.morphology.tagset.xml.Tag(element));
		}
	}

	// This attribute is mandatory
	public void setSymbol(String value) {
		_Symbol = value;
	}

	public String getSymbol() {
		return _Symbol;
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

	// This attribute is an array, possibly empty
	public void setDescription(org.neurpheus.nlp.morphology.tagset.xml.Description[] value) {
		if (value == null)
			value = new Description[0];
		_Description.clear();
		for (int i = 0; i < value.length; ++i) {
			_Description.add(value[i]);
		}
	}

	public void setDescription(int index, org.neurpheus.nlp.morphology.tagset.xml.Description value) {
		_Description.set(index, value);
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Description[] getDescription() {
		Description[] arr = new Description[_Description.size()];
		return (Description[]) _Description.toArray(arr);
	}

	public java.util.List fetchDescriptionList() {
		return _Description;
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Description getDescription(int index) {
		return (Description)_Description.get(index);
	}

	// Return the number of description
	public int sizeDescription() {
		return _Description.size();
	}

	public int addDescription(org.neurpheus.nlp.morphology.tagset.xml.Description value) {
		_Description.add(value);
		int positionOfNewItem = _Description.size()-1;
		return positionOfNewItem;
	}

	/**
	 * Search from the end looking for @param value, and then remove it.
	 */
	public int removeDescription(org.neurpheus.nlp.morphology.tagset.xml.Description value) {
		int pos = _Description.indexOf(value);
		if (pos >= 0) {
			_Description.remove(pos);
		}
		return pos;
	}

	// This attribute is an array, possibly empty
	public void setTag(org.neurpheus.nlp.morphology.tagset.xml.Tag[] value) {
		if (value == null)
			value = new Tag[0];
		_Tag.clear();
		for (int i = 0; i < value.length; ++i) {
			_Tag.add(value[i]);
		}
	}

	public void setTag(int index, org.neurpheus.nlp.morphology.tagset.xml.Tag value) {
		_Tag.set(index, value);
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Tag[] getTag() {
		Tag[] arr = new Tag[_Tag.size()];
		return (Tag[]) _Tag.toArray(arr);
	}

	public java.util.List fetchTagList() {
		return _Tag;
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Tag getTag(int index) {
		return (Tag)_Tag.get(index);
	}

	// Return the number of tag
	public int sizeTag() {
		return _Tag.size();
	}

	public int addTag(org.neurpheus.nlp.morphology.tagset.xml.Tag value) {
		_Tag.add(value);
		int positionOfNewItem = _Tag.size()-1;
		return positionOfNewItem;
	}

	/**
	 * Search from the end looking for @param value, and then remove it.
	 */
	public int removeTag(org.neurpheus.nlp.morphology.tagset.xml.Tag value) {
		int pos = _Tag.indexOf(value);
		if (pos >= 0) {
			_Tag.remove(pos);
		}
		return pos;
	}

	public void writeNode(java.io.Writer out, String nodeName, String indent) throws java.io.IOException {
		out.write(indent);
		out.write("<");
		out.write(nodeName);
		out.write(">\n");
		String nextIndent = indent + "	";
		if (_Symbol != null) {
			out.write(nextIndent);
			out.write("<symbol");	// NOI18N
			out.write(">");	// NOI18N
			org.neurpheus.nlp.morphology.tagset.xml.Tagset.writeXML(out, _Symbol, false);
			out.write("</symbol>\n");	// NOI18N
		}
		for (java.util.Iterator it = _Name.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = (org.neurpheus.nlp.morphology.tagset.xml.Name)it.next();
			if (element != null) {
				element.writeNode(out, "name", nextIndent);
			}
		}
		for (java.util.Iterator it = _Description.iterator(); 
			it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Description element = (org.neurpheus.nlp.morphology.tagset.xml.Description)it.next();
			if (element != null) {
				element.writeNode(out, "description", nextIndent);
			}
		}
		for (java.util.Iterator it = _Tag.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Tag element = (org.neurpheus.nlp.morphology.tagset.xml.Tag)it.next();
			if (element != null) {
				element.writeNode(out, "tag", nextIndent);
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
				_Symbol = childNodeValue;
			}
			else if (childNodeName == "name") {
				Name aName = new org.neurpheus.nlp.morphology.tagset.xml.Name();
				aName.readNode(childNode);
				_Name.add(aName);
			}
			else if (childNodeName == "description") {
				Description aDescription = new org.neurpheus.nlp.morphology.tagset.xml.Description();
				aDescription.readNode(childNode);
				_Description.add(aDescription);
			}
			else if (childNodeName == "tag") {
				Tag aTag = new org.neurpheus.nlp.morphology.tagset.xml.Tag();
				aTag.readNode(childNode);
				_Tag.add(aTag);
			}
			else {
				// Found extra unrecognized childNode
			}
		}
	}

	public void validate() throws org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException {
		boolean restrictionFailure = false;
		// Validating property symbol
		if (getSymbol() == null) {
			throw new org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException("getSymbol() == null", org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException.FailureType.NULL_VALUE, "symbol", this);	// NOI18N
		}
		// Validating property name
		for (int _index = 0; _index < sizeName(); ++_index) {
			org.neurpheus.nlp.morphology.tagset.xml.Name element = getName(_index);
			if (element != null) {
				element.validate();
			}
		}
		// Validating property description
		for (int _index = 0; _index < sizeDescription(); ++_index) {
			org.neurpheus.nlp.morphology.tagset.xml.Description element = getDescription(_index);
			if (element != null) {
				element.validate();
			}
		}
		// Validating property tag
		for (int _index = 0; _index < sizeTag(); ++_index) {
			org.neurpheus.nlp.morphology.tagset.xml.Tag element = getTag(_index);
			if (element != null) {
				element.validate();
			}
		}
	}

	public void changePropertyByName(String name, Object value) {
		if (name == null) return;
		name = name.intern();
		if (name == "symbol")
			setSymbol((String)value);
		else if (name == "name")
			addName((Name)value);
		else if (name == "name[]")
			setName((Name[]) value);
		else if (name == "description")
			addDescription((Description)value);
		else if (name == "description[]")
			setDescription((Description[]) value);
		else if (name == "tag")
			addTag((Tag)value);
		else if (name == "tag[]")
			setTag((Tag[]) value);
		else
			throw new IllegalArgumentException(name+" is not a valid property name for Category");
	}

	public Object fetchPropertyByName(String name) {
		if (name == "symbol")
			return getSymbol();
		if (name == "name[]")
			return getName();
		if (name == "description[]")
			return getDescription();
		if (name == "tag[]")
			return getTag();
		throw new IllegalArgumentException(name+" is not a valid property name for Category");
	}

	public String nameSelf() {
		return "category";
	}

	public String nameChild(Object childObj) {
		if (childObj instanceof Description) {
			Description child = (Description) childObj;
			int index = 0;
			for (java.util.Iterator it = _Description.iterator(); 
				it.hasNext(); ) {
				org.neurpheus.nlp.morphology.tagset.xml.Description element = (org.neurpheus.nlp.morphology.tagset.xml.Description)it.next();
				if (child == element) {
					return "description."+index;
				}
				++index;
			}
		}
		if (childObj instanceof String) {
			String child = (String) childObj;
			if (child == _Symbol) {
				return "symbol";
			}
		}
		if (childObj instanceof Tag) {
			Tag child = (Tag) childObj;
			int index = 0;
			for (java.util.Iterator it = _Tag.iterator(); it.hasNext(); ) {
				org.neurpheus.nlp.morphology.tagset.xml.Tag element = (org.neurpheus.nlp.morphology.tagset.xml.Tag)it.next();
				if (child == element) {
					return "tag."+index;
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
		for (java.util.Iterator it = _Description.iterator(); 
			it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Description element = (org.neurpheus.nlp.morphology.tagset.xml.Description)it.next();
			if (element != null) {
				if (recursive) {
					element.childBeans(true, beans);
				}
				beans.add(element);
			}
		}
		for (java.util.Iterator it = _Tag.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Tag element = (org.neurpheus.nlp.morphology.tagset.xml.Tag)it.next();
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
		if (!(o instanceof org.neurpheus.nlp.morphology.tagset.xml.Category))
			return false;
		org.neurpheus.nlp.morphology.tagset.xml.Category inst = (org.neurpheus.nlp.morphology.tagset.xml.Category) o;
		if (!(_Symbol == null ? inst._Symbol == null : _Symbol.equals(inst._Symbol))) {
			return false;
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
		if (sizeDescription() != inst.sizeDescription())
			return false;
		// Compare every element.
		for (java.util.Iterator it = _Description.iterator(), it2 = inst._Description.iterator(); 
			it.hasNext() && it2.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Description element = (org.neurpheus.nlp.morphology.tagset.xml.Description)it.next();
			org.neurpheus.nlp.morphology.tagset.xml.Description element2 = (org.neurpheus.nlp.morphology.tagset.xml.Description)it2.next();
			if (!(element == null ? element2 == null : element.equals(element2))) {
				return false;
			}
		}
		if (sizeTag() != inst.sizeTag())
			return false;
		// Compare every element.
		for (java.util.Iterator it = _Tag.iterator(), it2 = inst._Tag.iterator(); 
			it.hasNext() && it2.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Tag element = (org.neurpheus.nlp.morphology.tagset.xml.Tag)it.next();
			org.neurpheus.nlp.morphology.tagset.xml.Tag element2 = (org.neurpheus.nlp.morphology.tagset.xml.Tag)it2.next();
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
		result = 37*result + (_Description == null ? 0 : _Description.hashCode());
		result = 37*result + (_Tag == null ? 0 : _Tag.hashCode());
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
