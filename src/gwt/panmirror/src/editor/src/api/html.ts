/*
 * html.ts
 *
 * Copyright (C) 2019-20 by RStudio, PBC
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */

import { Node as ProsemirrorNode, Schema, DOMSerializer, Fragment } from 'prosemirror-model';
import { Type } from 'js-yaml';

export function isSingleLineHTML(html: string) {
  return html.trimRight().split('\n').length === 1;
}

export function asHTMLTag(
  tag: string,
  attribs: { [key: string]: string },
  selfClosing = false,
  noEmptyAttribs = false,
) {
  const attribsHTML = Object.keys(attribs)
    .filter(name => !noEmptyAttribs || attribs[name])
    .map(name => `${name}="${escapeHTMLAttribute(attribs[name])}"`)
    .join(' ');
  return `<${tag} ${attribsHTML}${selfClosing ? '/' : ''}>`;
}

export function escapeHTMLAttribute(value: string) {
  return value
    .replace(/&/g, '&amp;') // must be first replacement
    .replace(/'/g, '&apos;')
    .replace(/"/g, '&quot;')
    .replace(/</g, '&lt;')
    .replace(/>/g, '&gt;');
}

export function nodeToHTML(schema: Schema, node: ProsemirrorNode) {
  return generateHTML(() => DOMSerializer.fromSchema(schema).serializeNode(node));
}

export function fragmentToHTML(schema: Schema, fragment: Fragment) {
  return generateHTML(() => DOMSerializer.fromSchema(schema).serializeFragment(fragment));
}

function generateHTML(generator: () => Node | DocumentFragment) {
  const div = document.createElement('div');
  const output = generator();
  div.appendChild(output);
  return div.innerHTML;
}

// Way to use generic in testing a type
// See https://github.com/Microsoft/TypeScript/wiki/FAQ#why-cant-i-write-typeof-t-new-t-or-instanceof-t-in-my-generic-function
function isTypeInstanceOf<T>(ctor: { new(...args: any[]): T }, obj: T) {
  return obj instanceof ctor;
}
