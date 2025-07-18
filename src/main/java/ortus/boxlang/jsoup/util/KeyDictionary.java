/**
 * [BoxLang]
 *
 * Copyright [2023] [Ortus Solutions, Corp]
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package ortus.boxlang.jsoup.util;

import ortus.boxlang.runtime.scopes.Key;

/**
 * This class is used to store all the keys used in the dictionary for this module.
 */
public class KeyDictionary {

	public static final Key	moduleName				= new Key( "bxjsoup" );
	public static final Key	html					= Key.of( "html" );
	public static final Key	htmlHead				= Key.of( "htmlHead" );
	public static final Key	htmlParse				= Key.of( "htmlParse" );
	public static final Key	htmlFooter				= Key.of( "htmlFooter" );
	public static final Key	safeList				= Key.of( "safeList" );
	public static final Key	preserveRelativeLinks	= Key.of( "preserveRelativeLinks" );
	public static final Key	baseUri					= Key.of( "baseUri" );

}
