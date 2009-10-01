// wslib 2009
// correct display of all ascii characters from Document interpretation

/* example:
"bl�men".postln; // -> blümen
"bl�men".asciiCorrect.postln; // -> bl�men
*/

+ String {
	asciiCorrect { var str, table;
		str = this;
		table =  [				 
			[ [ 194, 160 ], 202 ],
			[ [ 194, 161 ], 193 ],
			[ [ 194, 162 ], 162 ],
			[ [ 194, 163 ], 163 ],
			[ [ 194, 165 ], 180 ],
			[ [ 194, 167 ], 164 ],
			[ [ 194, 168 ], 172 ],
			[ [ 194, 169 ], 169 ],
			[ [ 194, 170 ], 187 ],
			[ [ 194, 171 ], 199 ],
			[ [ 194, 174 ], 168 ],
			[ [ 194, 175 ], 248 ],
			[ [ 194, 176 ], 161 ],
			[ [ 194, 177 ], 177 ],
			[ [ 194, 180 ], 171 ],
			[ [ 194, 181 ], 181 ],
			[ [ 194, 182 ], 166 ],
			[ [ 194, 183 ], 225 ],
			[ [ 194, 184 ], 252 ],
			[ [ 194, 186 ], 188 ],
			[ [ 194, 187 ], 200 ],
			[ [ 194, 191 ], 192 ],
			[ [ 195, 129 ], 231 ],
			[ [ 195, 130 ], 229 ],
			[ [ 195, 131 ], 204 ],
			[ [ 195, 132 ], 128 ],
			[ [ 195, 133 ], 129 ],
			[ [ 195, 134 ], 174 ],
			[ [ 195, 135 ], 130 ],
			[ [ 195, 136 ], 233 ],
			[ [ 195, 137 ], 131 ],
			[ [ 195, 138 ], 230 ],
			[ [ 195, 139 ], 232 ],
			[ [ 195, 140 ], 237 ],
			[ [ 195, 141 ], 234 ],
			[ [ 195, 142 ], 235 ],
			[ [ 195, 143 ], 236 ],
			[ [ 195, 145 ], 132 ],
			[ [ 195, 146 ], 241 ],
			[ [ 195, 147 ], 238 ],
			[ [ 195, 149 ], 205 ],
			[ [ 195, 150 ], 133 ],
			[ [ 195, 152 ], 175 ],
			[ [ 195, 153 ], 244 ],
			[ [ 195, 154 ], 242 ],
			[ [ 195, 155 ], 243 ],
			[ [ 195, 156 ], 134 ],
			[ [ 195, 159 ], 167 ],
			[ [ 195, 160 ], 136 ],
			[ [ 195, 161 ], 135 ],
			[ [ 195, 162 ], 137 ],
			[ [ 195, 163 ], 139 ],
			[ [ 195, 164 ], 138 ],
			[ [ 195, 165 ], 140 ],
			[ [ 195, 166 ], 190 ],
			[ [ 195, 167 ], 141 ],
			[ [ 195, 168 ], 143 ],
			[ [ 195, 169 ], 142 ],
			[ [ 195, 170 ], 144 ],
			[ [ 195, 171 ], 145 ],
			[ [ 195, 172 ], 147 ],
			[ [ 195, 173 ], 146 ],
			[ [ 195, 174 ], 148 ],
			[ [ 195, 175 ], 149 ],
			[ [ 195, 177 ], 150 ],
			[ [ 195, 178 ], 152 ],
			[ [ 195, 179 ], 151 ],
			[ [ 195, 180 ], 153 ],
			[ [ 195, 181 ], 155 ],
			[ [ 195, 182 ], 154 ],
			[ [ 195, 183 ], 214 ],
			[ [ 195, 184 ], 191 ],
			[ [ 195, 185 ], 157 ],
			[ [ 195, 186 ], 156 ],
			[ [ 195, 187 ], 158 ],
			[ [ 195, 188 ], 159 ],
			[ [ 195, 191 ], 216 ],
			[ [ 196, 177 ], 245 ],
			[ [ 197, 184 ], 217 ],
			[ [ 203, 134 ], 246 ],
			[ [ 203, 135 ], 255 ],
			[ [ 203, 152 ], 249 ],
			[ [ 203, 153 ], 250 ],
			[ [ 203, 154 ], 251 ],
			[ [ 203, 155 ], 254 ],
			[ [ 203, 156 ], 247 ],
			[ [ 203, 157 ], 253 ],
			[ [ 206, 169 ], 189 ],
			[ [ 207, 128 ], 185 ],
			[ [ 226, 128, 147 ], 208 ],
			[ [ 226, 128, 148 ], 209 ],
			[ [ 226, 128, 152 ], 212 ],
			[ [ 226, 128, 153 ], 213 ],
			[ [ 226, 128, 156 ], 210 ],
			[ [ 226, 128, 157 ], 211 ],
			[ [ 226, 128, 158 ], 227 ],
			[ [ 226, 128, 160 ], 160 ],
			[ [ 226, 128, 161 ], 224 ],
			[ [ 226, 128, 162 ], 165 ],
			[ [ 226, 128, 166 ], 201 ],
			[ [ 226, 128, 176 ], 228 ],
			[ [ 226, 128, 185 ], 220 ],
			[ [ 226, 128, 186 ], 221 ],
			[ [ 226, 129, 132 ], 218 ],
			[ [ 226, 130, 172 ], 219 ],
			[ [ 226, 132, 162 ], 170 ],
			[ [ 226, 136, 130 ], 182 ],
			[ [ 226, 136, 143 ], 184 ],
			[ [ 226, 136, 145 ], 183 ],
			[ [ 226, 136, 158 ], 176 ],
			[ [ 226, 136, 171 ], 186 ],
			[ [ 226, 137, 160 ], 173 ],
			[ [ 226, 137, 164 ], 178 ],
			[ [ 226, 137, 165 ], 179 ],
			[ [ 226, 151, 138 ], 215 ],
			[ [ 239, 163, 191 ], 240 ],
			[ [ 239, 172, 129 ], 222 ],
			[ [ 239, 172, 130 ], 223 ],
		// checked and reshuffled to eliminate all possible double conversions:
			[ [ 194, 172 ], 194 ],
			[ [ 198, 146 ], 196 ],
			[ [ 226, 136, 134 ], 198 ],
			[ [ 195, 128 ], 203 ],
			[ [ 195, 148 ], 239 ],
			[ [ 226, 136, 154 ], 195 ],
			[ [ 197, 146 ], 206 ],
			[ [ 197, 147 ], 207 ],
			[ [ 226, 137, 136 ], 197 ],
			[ [ 226, 128, 154 ], 226 ] ];
			
		table.do({ |item|
			str = str.replace( item[0].collect(_.asAscii).join, item[1].asAscii ) 
			});
			
		^str;
		}
	}
	
// table was created with the following code:

/* (
d = Document.new;
c = []; // the table
128.do({ |i| // test all > 127 chars in a real Document
	d.string = (i+128).asAscii.asString;
	c = c.add( [ d.string.as( Array ).collect(_.ascii), i+128 ] );
	});
d.close;

c = c.sort({ |a,b| // sort
	(a[0] * [1, 1/256, (1/256)/256]).sum <= (b[0] * [1, 1/256, (1/256)/256]).sum
	});
	
e = c.removeAllSuchThat({ |item| // move escape chars to end
	[194, 195, 196, 197, 198, 203, 206, 207, 226, 239].includes( item.last ); })
		.sort({ |a,b| a.last <= b.last });
c = c ++ e;
) */