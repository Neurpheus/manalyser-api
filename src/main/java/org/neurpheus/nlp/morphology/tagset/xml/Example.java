/**
 *	This generated bean class Example
 *	matches the schema element 'example'.
 *  The root bean class is Tagset
 *
 *	Generated on Sun Aug 07 18:01:13 CEST 2016
 * @generated
 */

package org.neurpheus.nlp.morphology.tagset.xml;

public class Example {
	private String _Lang;
	private String _Value;

	public Example() {
		_Lang = "";
		_Value = "";
	}

	/**
	 * Required parameters constructor
	 */
	public Example(String lang, String value) {
		_Lang = lang;
		_Value = value;
	}

	/**
	 * Deep copy
	 */
	public Example(org.neurpheus.nlp.morphology.tagset.xml.Example source) {
		_Lang = source._Lang;
		_Value = source._Value;
	}

	// This attribute is mandatory
	public void setLang(String value) {
		_Lang = value;
	}

	public String getLang() {
		return _Lang;
	}

	// This attribute is mandatory
	public void setValue(String value) {
		_Value = value;
	}

	public String getValue() {
		return _Value;
	}

	public void writeNode(java.io.Writer out, String nodeName, String indent) throws java.io.IOException {
		out.write(indent);
		out.write("<");
		out.write(nodeName);
		out.write(">\n");
		String nextIndent = indent + "	";
		if (_Lang != null) {
			out.write(nextIndent);
			out.write("<lang");	// NOI18N
			out.write(">");	// NOI18N
			org.neurpheus.nlp.morphology.tagset.xml.Tagset.writeXML(out, _Lang, false);
			out.write("</lang>\n");	// NOI18N
		}
		if (_Value != null) {
			out.write(nextIndent);
			out.write("<value");	// NOI18N
			out.write(">");	// NOI18N
			org.neurpheus.nlp.morphology.tagset.xml.Tagset.writeXML(out, _Value, false);
			out.write("</value>\n");	// NOI18N
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
			if (childNodeName == "lang") {
				_Lang = childNodeValue;
			}
			else if (childNodeName == "value") {
				_Value = childNodeValue;
			}
			else {
				// Found extra unrecognized childNode
			}
		}
	}

	public void validate() throws org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException {
		boolean restrictionFailure = false;
		// Validating property lang
		if (getLang() == null) {
			throw new org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException("getLang() == null", org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException.FailureType.NULL_VALUE, "lang", this);	// NOI18N
		}
		// Validating property value
		if (getValue() == null) {
			throw new org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException("getValue() == null", org.neurpheus.nlp.morphology.tagset.xml.Tagset.ValidateException.FailureType.NULL_VALUE, "value", this);	// NOI18N
		}
	}

	public void changePropertyByName(String name, Object value) {
		if (name == null) return;
		name = name.intern();
		if (name == "lang")
			setLang((String)value);
		else if (name == "value")
			setValue((String)value);
		else
			throw new IllegalArgumentException(name+" is not a valid property name for Example");
	}

	public Object fetchPropertyByName(String name) {
		if (name == "lang")
			return getLang();
		if (name == "value")
			return getValue();
		throw new IllegalArgumentException(name+" is not a valid property name for Example");
	}

	public String nameSelf() {
		return "example";
	}

	public String nameChild(Object childObj) {
		if (childObj instanceof String) {
			String child = (String) childObj;
			if (child == _Lang) {
				return "lang";
			}
			if (child == _Value) {
				return "value";
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
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof org.neurpheus.nlp.morphology.tagset.xml.Example))
			return false;
		org.neurpheus.nlp.morphology.tagset.xml.Example inst = (org.neurpheus.nlp.morphology.tagset.xml.Example) o;
		if (!(_Lang == null ? inst._Lang == null : _Lang.equals(inst._Lang))) {
			return false;
		}
		if (!(_Value == null ? inst._Value == null : _Value.equals(inst._Value))) {
			return false;
		}
		return true;
	}

	public int hashCode() {
		int result = 17;
		result = 37*result + (_Lang == null ? 0 : _Lang.hashCode());
		result = 37*result + (_Value == null ? 0 : _Value.hashCode());
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
