class OrdnetPar implements Par<K, V> {
  K key;
  V value;
  OrdnetPar nabo;

  public OrdnetPar(K key, V value) {
    this.key = key;
    this.value = value;

  }

  public void settNabo(OrdnetPar n) {
    nabo = n;
  }
  @Override
  public K hentNokkel() {
    return key;
  }
  @Override
  public V hentVerdi() {
    return value;
  }
}
