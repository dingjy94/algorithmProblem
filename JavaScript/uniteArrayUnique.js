// ([1, 2, 3], [3, 2, 5]) => [1, 2, 3, 5]

function uniteUnique(...arr) {
  return [...new Set([].concat(...arr))];
}
