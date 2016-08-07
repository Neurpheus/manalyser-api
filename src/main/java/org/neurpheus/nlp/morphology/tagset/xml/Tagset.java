/**
 *	This generated bean class Tagset
 *	matches the schema element 'tagset'.
 *
 *	Generated on Sun Aug 07 18:01:13 CEST 2016
 *
 *	This class matches the root element of the DTD,
 *	and is the root of the bean graph.
 *
 * 	tagset : Tagset
 * 		[attr: xmlns CDATA #IMPLIED ]
 * 		language : Language[0,n]
 * 			symbol : String[1,n]
 * 			name : Name[0,n]
 * 				lang : String
 * 				value : String
 * 		category : Category[0,n]
 * 			symbol : String
 * 			name : Name[0,n]
 * 				lang : String
 * 				value : String
 * 			description : Description[0,n]
 * 				lang : String
 * 				value : String
 * 			tag : Tag[0,n]
 * 				symbol : String
 * 				name : Name[0,n]
 * 					lang : String
 * 					value : String
 * 				description : Description[0,n]
 * 					lang : String
 * 					value : String
 * 				example : Example[0,n]
 * 					lang : String
 * 					value : String
 *
 * @generated
 */

package org.neurpheus.nlp.morphology.tagset.xml;

public class Tagset {
	private java.lang.String _Xmlns;
	private java.util.List _Language = new java.util.ArrayList();	// List<Language>
	private java.util.List _Category = new java.util.ArrayList();	// List<Category>
	private java.lang.String schemaLocation;

	public Tagset() {
	}

	/**
	 * Deep copy
	 */
	public Tagset(org.neurpheus.nlp.morphology.tagset.xml.Tagset source) {
		_Xmlns = source._Xmlns;
		for (java.util.Iterator it = source._Language.iterator(); 
			it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Language element = (org.neurpheus.nlp.morphology.tagset.xml.Language)it.next();
			_Language.add((element == null) ? null : new org.neurpheus.nlp.morphology.tagset.xml.Language(element));
		}
		for (java.util.Iterator it = source._Category.iterator(); 
			it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Category element = (org.neurpheus.nlp.morphology.tagset.xml.Category)it.next();
			_Category.add((element == null) ? null : new org.neurpheus.nlp.morphology.tagset.xml.Category(element));
		}
		schemaLocation = source.schemaLocation;
	}

	// This attribute is optional
	public void setXmlns(java.lang.String value) {
		_Xmlns = value;
	}

	public java.lang.String getXmlns() {
		return _Xmlns;
	}

	// This attribute is an array, possibly empty
	public void setLanguage(org.neurpheus.nlp.morphology.tagset.xml.Language[] value) {
		if (value == null)
			value = new Language[0];
		_Language.clear();
		for (int i = 0; i < value.length; ++i) {
			_Language.add(value[i]);
		}
	}

	public void setLanguage(int index, org.neurpheus.nlp.morphology.tagset.xml.Language value) {
		_Language.set(index, value);
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Language[] getLanguage() {
		Language[] arr = new Language[_Language.size()];
		return (Language[]) _Language.toArray(arr);
	}

	public java.util.List fetchLanguageList() {
		return _Language;
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Language getLanguage(int index) {
		return (Language)_Language.get(index);
	}

	// Return the number of language
	public int sizeLanguage() {
		return _Language.size();
	}

	public int addLanguage(org.neurpheus.nlp.morphology.tagset.xml.Language value) {
		_Language.add(value);
		int positionOfNewItem = _Language.size()-1;
		return positionOfNewItem;
	}

	/**
	 * Search from the end looking for @param value, and then remove it.
	 */
	public int removeLanguage(org.neurpheus.nlp.morphology.tagset.xml.Language value) {
		int pos = _Language.indexOf(value);
		if (pos >= 0) {
			_Language.remove(pos);
		}
		return pos;
	}

	// This attribute is an array, possibly empty
	public void setCategory(org.neurpheus.nlp.morphology.tagset.xml.Category[] value) {
		if (value == null)
			value = new Category[0];
		_Category.clear();
		for (int i = 0; i < value.length; ++i) {
			_Category.add(value[i]);
		}
	}

	public void setCategory(int index, org.neurpheus.nlp.morphology.tagset.xml.Category value) {
		_Category.set(index, value);
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Category[] getCategory() {
		Category[] arr = new Category[_Category.size()];
		return (Category[]) _Category.toArray(arr);
	}

	public java.util.List fetchCategoryList() {
		return _Category;
	}

	public org.neurpheus.nlp.morphology.tagset.xml.Category getCategory(int index) {
		return (Category)_Category.get(index);
	}

	// Return the number of category
	public int sizeCategory() {
		return _Category.size();
	}

	public int addCategory(org.neurpheus.nlp.morphology.tagset.xml.Category value) {
		_Category.add(value);
		int positionOfNewItem = _Category.size()-1;
		return positionOfNewItem;
	}

	/**
	 * Search from the end looking for @param value, and then remove it.
	 */
	public int removeCategory(org.neurpheus.nlp.morphology.tagset.xml.Category value) {
		int pos = _Category.indexOf(value);
		if (pos >= 0) {
			_Category.remove(pos);
		}
		return pos;
	}

	public void _setSchemaLocation(String location) {
		schemaLocation = location;
	}

	public String _getSchemaLocation() {
		return schemaLocation;
	}

	public void write(java.io.OutputStream out) throws java.io.IOException {
		write(out, null);
	}

	public void write(java.io.OutputStream out, String encoding) throws java.io.IOException {
		java.io.Writer w;
		if (encoding == null) {
			encoding = "UTF-8";	// NOI18N
		}
		w = new java.io.BufferedWriter(new java.io.OutputStreamWriter(out, encoding));
		write(w, encoding);
		w.flush();
	}

	/**
	 * Print this Java Bean to @param out including an XML header.
	 * @param encoding is the encoding style that @param out was opened with.
	 */
	public void write(java.io.Writer out, String encoding) throws java.io.IOException {
		out.write("<?xml version='1.0'");	// NOI18N
		if (encoding != null)
			out.write(" encoding='"+encoding+"'");	// NOI18N
		out.write(" ?>\n");	// NOI18N
		writeNode(out, "tagset", "");	// NOI18N
	}

	public void writeNode(java.io.Writer out, String nodeName, String indent) throws java.io.IOException {
		out.write(indent);
		out.write("<");
		out.write(nodeName);
		if (schemaLocation != null) {
			out.write(" xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:schemaLocation='");
			out.write(schemaLocation);
			out.write("'");	// NOI18N
		}
		// xmlns is an attribute
		if (_Xmlns != null) {
			out.write(" xmlns");	// NOI18N
			out.write("='");	// NOI18N
			org.neurpheus.nlp.morphology.tagset.xml.Tagset.writeXML(out, _Xmlns, true);
			out.write("'");	// NOI18N
		}
		out.write(">\n");
		String nextIndent = indent + "	";
		for (java.util.Iterator it = _Language.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Language element = (org.neurpheus.nlp.morphology.tagset.xml.Language)it.next();
			if (element != null) {
				element.writeNode(out, "language", nextIndent);
			}
		}
		for (java.util.Iterator it = _Category.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Category element = (org.neurpheus.nlp.morphology.tagset.xml.Category)it.next();
			if (element != null) {
				element.writeNode(out, "category", nextIndent);
			}
		}
		out.write(indent);
		out.write("</"+nodeName+">\n");
	}

	public static Tagset read(java.io.InputStream in) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException, java.io.IOException {
		return read(new org.xml.sax.InputSource(in), false, null, null);
	}

	/**
	 * Warning: in readNoEntityResolver character and entity references will
	 * not be read from any DTD in the XML source.
	 * However, this way is faster since no DTDs are looked up
	 * (possibly skipping network access) or parsed.
	 */
	public static Tagset readNoEntityResolver(java.io.InputStream in) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException, java.io.IOException {
		return read(new org.xml.sax.InputSource(in), false,
			new org.xml.sax.EntityResolver() {
			public org.xml.sax.InputSource resolveEntity(String publicId, String systemId) {
				java.io.ByteArrayInputStream bin = new java.io.ByteArrayInputStream(new byte[0]);
				return new org.xml.sax.InputSource(bin);
			}
		}
			, null);
	}

	public static Tagset read(org.xml.sax.InputSource in, boolean validate, org.xml.sax.EntityResolver er, org.xml.sax.ErrorHandler eh) throws javax.xml.parsers.ParserConfigurationException, org.xml.sax.SAXException, java.io.IOException {
		javax.xml.parsers.DocumentBuilderFactory dbf = javax.xml.parsers.DocumentBuilderFactory.newInstance();
		dbf.setValidating(validate);
		javax.xml.parsers.DocumentBuilder db = dbf.newDocumentBuilder();
		if (er != null)	db.setEntityResolver(er);
		if (eh != null)	db.setErrorHandler(eh);
		org.w3c.dom.Document doc = db.parse(in);
		return read(doc);
	}

	public static Tagset read(org.w3c.dom.Document document) {
		Tagset aTagset = new Tagset();
		aTagset.readNode(document.getDocumentElement());
		return aTagset;
	}

	public void readNode(org.w3c.dom.Node node) {
		if (node.hasAttributes()) {
			org.w3c.dom.NamedNodeMap attrs = node.getAttributes();
			org.w3c.dom.Attr attr;
			java.lang.String attrValue;
			attr = (org.w3c.dom.Attr) attrs.getNamedItem("xsi:schemaLocation");
			if (attr != null) {
				attrValue = attr.getValue();
			} else {
				attrValue = null;
			}
			schemaLocation = attrValue;
			attr = (org.w3c.dom.Attr) attrs.getNamedItem("xmlns");
			if (attr != null) {
				attrValue = attr.getValue();
			} else {
				attrValue = null;
			}
			_Xmlns = attrValue;
		}
		org.w3c.dom.NodeList children = node.getChildNodes();
		for (int i = 0, size = children.getLength(); i < size; ++i) {
			org.w3c.dom.Node childNode = children.item(i);
			String childNodeName = (childNode.getLocalName() == null ? childNode.getNodeName().intern() : childNode.getLocalName().intern());
			String childNodeValue = "";
			if (childNode.getFirstChild() != null) {
				childNodeValue = childNode.getFirstChild().getNodeValue();
			}
			if (childNodeName == "language") {
				Language aLanguage = new org.neurpheus.nlp.morphology.tagset.xml.Language();
				aLanguage.readNode(childNode);
				_Language.add(aLanguage);
			}
			else if (childNodeName == "category") {
				Category aCategory = new org.neurpheus.nlp.morphology.tagset.xml.Category();
				aCategory.readNode(childNode);
				_Category.add(aCategory);
			}
			else {
				// Found extra unrecognized childNode
			}
		}
	}

	/**
	 * Takes some text to be printed into an XML stream and escapes any
	 * characters that might make it invalid XML (like '<').
	 */
	public static void writeXML(java.io.Writer out, String msg) throws java.io.IOException {
		writeXML(out, msg, true);
	}

	public static void writeXML(java.io.Writer out, String msg, boolean attribute) throws java.io.IOException {
		if (msg == null)
			return;
		int msgLength = msg.length();
		for (int i = 0; i < msgLength; ++i) {
			char c = msg.charAt(i);
			writeXML(out, c, attribute);
		}
	}

	public static void writeXML(java.io.Writer out, char msg, boolean attribute) throws java.io.IOException {
		if (msg == '&')
			out.write("&amp;");
		else if (msg == '<')
			out.write("&lt;");
		else if (msg == '>')
			out.write("&gt;");
		else if (attribute && msg == '"')
			out.write("&quot;");
		else if (attribute && msg == '\'')
			out.write("&apos;");
		else if (attribute && msg == '\n')
			out.write("&#xA;");
		else if (attribute && msg == '\t')
			out.write("&#x9;");
		else
			out.write(msg);
	}

	public static class ValidateException extends Exception {
		private java.lang.Object failedBean;
		private String failedPropertyName;
		private FailureType failureType;
		public ValidateException(String msg, String failedPropertyName, java.lang.Object failedBean) {
			super(msg);
			this.failedBean = failedBean;
			this.failedPropertyName = failedPropertyName;
		}
		public ValidateException(String msg, FailureType ft, String failedPropertyName, java.lang.Object failedBean) {
			super(msg);
			this.failureType = ft;
			this.failedBean = failedBean;
			this.failedPropertyName = failedPropertyName;
		}
		public String getFailedPropertyName() {return failedPropertyName;}
		public FailureType getFailureType() {return failureType;}
		public java.lang.Object getFailedBean() {return failedBean;}
		public static class FailureType {
			private final String name;
			private FailureType(String name) {this.name = name;}
			public String toString() { return name;}
			public static final FailureType NULL_VALUE = new FailureType("NULL_VALUE");
			public static final FailureType DATA_RESTRICTION = new FailureType("DATA_RESTRICTION");
			public static final FailureType ENUM_RESTRICTION = new FailureType("ENUM_RESTRICTION");
			public static final FailureType MUTUALLY_EXCLUSIVE = new FailureType("MUTUALLY_EXCLUSIVE");
		}
	}

	public void validate() throws org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException {
		boolean restrictionFailure = false;
		// Validating property xmlns
		// Validating property language
		for (int _index = 0; _index < sizeLanguage(); ++_index) {
			org.neurpheus.nlp.morphology.tagset.xml.Language element = getLanguage(_index);
			if (element != null) {
				element.validate();
			}
		}
		// Validating property category
		for (int _index = 0; _index < sizeCategory(); ++_index) {
			org.neurpheus.nlp.morphology.tagset.xml.Category element = getCategory(_index);
			if (element != null) {
				element.validate();
			}
		}
	}

	public void changePropertyByName(String name, Object value) {
		if (name == null) return;
		name = name.intern();
		if (name == "xmlns")
			setXmlns((java.lang.String)value);
		else if (name == "language")
			addLanguage((Language)value);
		else if (name == "language[]")
			setLanguage((Language[]) value);
		else if (name == "category")
			addCategory((Category)value);
		else if (name == "category[]")
			setCategory((Category[]) value);
		else
			throw new IllegalArgumentException(name+" is not a valid property name for Tagset");
	}

	public Object fetchPropertyByName(String name) {
		if (name == "xmlns")
			return getXmlns();
		if (name == "language[]")
			return getLanguage();
		if (name == "category[]")
			return getCategory();
		throw new IllegalArgumentException(name+" is not a valid property name for Tagset");
	}

	public String nameSelf() {
		return "/tagset";
	}

	public String nameChild(Object childObj) {
		if (childObj instanceof Category) {
			Category child = (Category) childObj;
			int index = 0;
			for (java.util.Iterator it = _Category.iterator(); 
				it.hasNext(); ) {
				org.neurpheus.nlp.morphology.tagset.xml.Category element = (org.neurpheus.nlp.morphology.tagset.xml.Category)it.next();
				if (child == element) {
					return "category."+index;
				}
				++index;
			}
		}
		if (childObj instanceof Language) {
			Language child = (Language) childObj;
			int index = 0;
			for (java.util.Iterator it = _Language.iterator(); 
				it.hasNext(); ) {
				org.neurpheus.nlp.morphology.tagset.xml.Language element = (org.neurpheus.nlp.morphology.tagset.xml.Language)it.next();
				if (child == element) {
					return "language."+index;
				}
				++index;
			}
		}
		if (childObj instanceof java.lang.String) {
			java.lang.String child = (java.lang.String) childObj;
			if (child == _Xmlns) {
				return "xmlns";
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
		for (java.util.Iterator it = _Language.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Language element = (org.neurpheus.nlp.morphology.tagset.xml.Language)it.next();
			if (element != null) {
				if (recursive) {
					element.childBeans(true, beans);
				}
				beans.add(element);
			}
		}
		for (java.util.Iterator it = _Category.iterator(); it.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Category element = (org.neurpheus.nlp.morphology.tagset.xml.Category)it.next();
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
		if (!(o instanceof org.neurpheus.nlp.morphology.tagset.xml.Tagset))
			return false;
		org.neurpheus.nlp.morphology.tagset.xml.Tagset inst = (org.neurpheus.nlp.morphology.tagset.xml.Tagset) o;
		if (!(_Xmlns == null ? inst._Xmlns == null : _Xmlns.equals(inst._Xmlns))) {
			return false;
		}
		if (sizeLanguage() != inst.sizeLanguage())
			return false;
		// Compare every element.
		for (java.util.Iterator it = _Language.iterator(), it2 = inst._Language.iterator(); 
			it.hasNext() && it2.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Language element = (org.neurpheus.nlp.morphology.tagset.xml.Language)it.next();
			org.neurpheus.nlp.morphology.tagset.xml.Language element2 = (org.neurpheus.nlp.morphology.tagset.xml.Language)it2.next();
			if (!(element == null ? element2 == null : element.equals(element2))) {
				return false;
			}
		}
		if (sizeCategory() != inst.sizeCategory())
			return false;
		// Compare every element.
		for (java.util.Iterator it = _Category.iterator(), it2 = inst._Category.iterator(); 
			it.hasNext() && it2.hasNext(); ) {
			org.neurpheus.nlp.morphology.tagset.xml.Category element = (org.neurpheus.nlp.morphology.tagset.xml.Category)it.next();
			org.neurpheus.nlp.morphology.tagset.xml.Category element2 = (org.neurpheus.nlp.morphology.tagset.xml.Category)it2.next();
			if (!(element == null ? element2 == null : element.equals(element2))) {
				return false;
			}
		}
		return true;
	}

	public int hashCode() {
		int result = 17;
		result = 37*result + (_Xmlns == null ? 0 : _Xmlns.hashCode());
		result = 37*result + (_Language == null ? 0 : _Language.hashCode());
		result = 37*result + (_Category == null ? 0 : _Category.hashCode());
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
