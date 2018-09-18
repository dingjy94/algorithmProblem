// A(1) -> N(14) Z -> M  

function rot13(str) { // LBH QVQ VG!
  
  return str.replace(/\w/g, (match) => {
      let charCode = match.charCodeAt(0) + 13;
      charCode = charCode > 90 ? charCode - 26 : charCode;
      return String.fromCharCode(charCode);
  });
}

// Change the inputs below to test
console.log(rot13("SERR PBQR PNZC"));
