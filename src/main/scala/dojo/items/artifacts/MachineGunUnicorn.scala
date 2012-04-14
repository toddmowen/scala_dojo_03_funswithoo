package dojo.items.artifacts

import dojo.items.TimedItem


class MachineGunUnicorn extends ArtifactItem with TimedItem {
  val id = 2
  val delay = 60
  protected def action = "Bam-Bam"
}
